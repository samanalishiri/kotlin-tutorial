package com.saman.tutorial.kotlin.pattern
/**
 * this class is singleton
 * */
object StringPool {
    private val pool = mutableSetOf<String>()

    fun add(element: String){
        pool.add(element)
    }

    fun get():String{
        return pool.first()
    }

    fun size():Int{
        return pool.size
    }

}