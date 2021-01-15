package com.saman.tutorial.shop.service

import com.saman.tutorial.shop.domain.AbstractModel
import com.saman.tutorial.shop.repository.CrudRepository
import com.saman.tutorial.shop.repository.ReadOnlyRepository

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
abstract class AbstractService<I, M : AbstractModel<I>, B : AbstractModel.AbstractBuilder<I, M>, R>
    (private val repository: R) : CrudService<I, M, R>, ReadOnlyService<I, M, R>
        where R : CrudRepository<I, M>, R : ReadOnlyRepository<I, M> {

    override fun save(m: M) = repository.save(m)

    override fun findById(id: I) = repository.findById(id)

    override fun update(id: I, m: M) = repository.update(id, m)

    override fun deleteById(id: I) = repository.deleteById(id)

    override fun findAll() = repository.findAll()
}