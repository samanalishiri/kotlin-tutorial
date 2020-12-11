package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.model.AbstractModel
import com.saman.tutorial.shop.storage.BeanFactory
import com.saman.tutorial.shop.storage.Storage
import com.saman.tutorial.shop.storage.StorageProvider
import com.saman.tutorial.shop.storage.StorageProvider.STORAGE_BEAN
import java.util.*
import java.util.Optional.ofNullable

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
abstract class AbstractRepository<I, M : AbstractModel<I>, B : AbstractModel.AbstractBuilder<I, M>> : Crud<I, M> {

    private val storage: Storage = BeanFactory.getBean(STORAGE_BEAN)

    abstract fun getMapName(): String

    abstract fun getBuilder(): B

    abstract fun nextId(): I

    override fun save(m: M): Optional<I> {
        val id = nextId()
        storage.push(getMapName(), id, getBuilder().from(m).id(id).build())
        return ofNullable(id)
    }

    override fun findById(id: I): Optional<M> {
        return storage.get(getMapName(), id)
    }

    override fun update(id: I, m: M) {
        storage.update(getMapName(), id, getBuilder().from(m).version().build())
    }

    override fun deleteById(id: I) {
        storage.delete(getMapName(), id)
    }
}