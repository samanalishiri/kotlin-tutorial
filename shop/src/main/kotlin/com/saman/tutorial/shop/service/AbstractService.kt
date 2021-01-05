package com.saman.tutorial.shop.service

import com.saman.tutorial.shop.domain.AbstractModel
import com.saman.tutorial.shop.repository.CrudRepository
import com.saman.tutorial.shop.repository.ReadOnlyRepository
import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
abstract class AbstractService<I, M : AbstractModel<I>, B : AbstractModel.AbstractBuilder<I, M>, R>
    : CrudService<I, M, R>, ReadOnlyService<I, M, R> where R : CrudRepository<I, M>, R : ReadOnlyRepository<I, M> {

    private val repository: R

    constructor(repository: R) {
        this.repository = repository
    }

    override fun save(m: M): Optional<I> {
        return repository.save(m)
    }

    override fun findById(id: I): Optional<M> {
        return repository.findById(id)
    }

    override fun update(id: I, m: M) {
        repository.update(id, m)
    }

    override fun deleteById(id: I) {
        repository.deleteById(id)
    }

    override fun findAll(): List<M> {
        return repository.findAll()
    }
}