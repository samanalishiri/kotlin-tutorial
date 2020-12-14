package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.model.AbstractModel

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
interface ReadOnly<I, M : AbstractModel<I>> {
    fun findAll(): List<M>
}
