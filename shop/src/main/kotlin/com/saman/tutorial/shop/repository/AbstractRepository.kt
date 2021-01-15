package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.domain.AbstractModel
import com.saman.tutorial.shop.storage.BeanFactory
import com.saman.tutorial.shop.storage.STORAGE_BEAN
import com.saman.tutorial.shop.storage.Storage
import java.util.*
import java.util.Optional.ofNullable
import java.util.stream.Collectors.toList

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
abstract class AbstractRepository<I, M : AbstractModel<I>, B : AbstractModel.AbstractBuilder<I, M>> :
    CrudRepository<I, M>, ReadOnlyRepository<I, M> {

    private val storage: Storage = BeanFactory.getBean(STORAGE_BEAN)

    abstract fun getMapName(): String

    abstract fun getBuilder(m: M): B

    abstract fun nextId(): I

    override fun save(m: M): Optional<I> {
        val id = nextId()
        m.identity = id
        beforeSave(m)
        storage.push(getMapName(), id, m)
        return ofNullable(id)
    }

    protected open fun beforeSave(model: M) {}

    override fun findById(id: I): Optional<M> = storage.get(getMapName(), id)

    override fun update(id: I, m: M) = storage.update(getMapName(), id, getBuilder(m).from(m).version().build())

    override fun deleteById(id: I) = storage.delete(getMapName(), id)

    override fun findAll(): List<M> {
        val map: Optional<MutableMap<I, M>> = storage.get(getMapName())
        if (!map.isPresent)
            return Collections.emptyList()

        return map.get().entries.stream()
            .map { it.value }
            .collect(toList())
    }
}