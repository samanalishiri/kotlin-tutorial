package com.saman.tutorial.kotlin.pattern

/**
 * this class is singleton
 * */
object StringStack {
    private val pool = mutableSetOf<String>()

    fun add(element: String) {
        pool.add(element)
    }

    fun get(): String {
        return pool.last()
    }

    fun size(): Int {
        return pool.size
    }

    fun clear() {
        pool.clear();
    }

}