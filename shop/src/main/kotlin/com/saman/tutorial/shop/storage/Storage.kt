package com.saman.tutorial.shop.storage

import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
interface Storage {
    fun create(name: String)
    fun <I, M> get(name: String): Optional<MutableMap<I, M>>
    fun drop(name: String)
    fun trunc(name: String)
    fun <I, M> push(name: String, id: I, value: M)
    fun <I, M> get(name: String, id: I): Optional<M>
    fun <I, M> update(name: String, id: I, value: M)
    fun <I> delete(name: String, id: I)
}