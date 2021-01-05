package com.saman.tutorial.shop.service

import com.saman.tutorial.shop.domain.AbstractModel
import com.saman.tutorial.shop.repository.ReadOnlyRepository

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
interface ReadOnlyService<I, M : AbstractModel<I>, R : ReadOnlyRepository<I, M>> {
    fun findAll(): List<M>
}
