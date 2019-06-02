package com.saman.tutorial.kotlin.pattern

object StringPoolSingleton {
    private val pool = mutableSetOf<String>()

    fun add(element: String){
        pool.add(element)
    }

    fun get():String{
        return pool.first()
    }

}