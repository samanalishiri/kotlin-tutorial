package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.model.AbstractModel
import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
interface Crud<I, M : AbstractModel<I>> {

    fun save(m: M): Optional<I>

    fun findById(id: I): Optional<M>

    fun update(id: I, m: M)

    fun deleteById(id: I)
}
