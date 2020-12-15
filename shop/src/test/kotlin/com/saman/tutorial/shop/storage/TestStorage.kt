package com.saman.tutorial.shop.storage

import java.util.*
import java.util.Optional.ofNullable

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class TestStorage : Storage {
    private val map: MutableMap<String, MutableMap<Any, Any>> = mutableMapOf()

    override fun create(name: String) {
        map.putIfAbsent(name, mutableMapOf())
    }

    override fun <I, M> get(name: String): Optional<MutableMap<I, M>> {
        return ofNullable(map[name] as MutableMap<I, M>)
    }

    override fun drop(name: String) {
        map.remove(name)
    }

    override fun trunc(name: String) {
        map.put(name, mutableMapOf())!!
    }

    override fun <I, M> push(name: String, id: I, value: M) {
        map[name]!!.putIfAbsent(id as Any, value as Any)
    }

    override fun <I, M> get(name: String, id: I): Optional<M> {
        return ofNullable(map[name]?.get(id as Any) as M)
    }

    override fun <I, M> update(name: String, id: I, value: M) {
        map[name]!![id as Any] = value as Any
    }

    override fun <I> delete(name: String, id: I) {
        map[name]!!.remove(id as Any)
    }
}
