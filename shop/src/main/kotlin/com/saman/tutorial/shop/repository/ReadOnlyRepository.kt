package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.domain.AbstractModel

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
interface ReadOnlyRepository<I, M : AbstractModel<I>> {
    fun findAll(): List<M>
}
