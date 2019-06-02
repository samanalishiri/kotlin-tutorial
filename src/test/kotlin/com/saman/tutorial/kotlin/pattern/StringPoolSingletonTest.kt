package com.saman.tutorial.kotlin.pattern

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class StringPoolSingletonTest {

    @Test
    fun addTwoElement() {
        StringPoolSingleton.add("A")
        StringPoolSingleton.add("B")
    }

    @Test
    fun getFirstElement() {
        val theElement = StringPoolSingleton.get()
        Assert.assertEquals("the first element is $theElement","A", theElement)
    }
}