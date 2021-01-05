package com.saman.tutorial.shop.service

import com.saman.tutorial.shop.domain.AbstractModel
import com.saman.tutorial.shop.repository.CrudRepository
import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
interface CrudService<I, M : AbstractModel<I>, R : CrudRepository<I, M>> {

    fun save(m: M): Optional<I>

    fun findById(id: I): Optional<M>

    fun update(id: I, m: M)

    fun deleteById(id: I)
}
