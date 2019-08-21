package com.saman.tutorial.kotlin.pattern

import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

class StringPoolTest {

    @Test
    fun addTwoElementToStringPool() {
        StringPool.add("A")
        StringPool.add("B")

        assertEquals(2, StringPool.size())
    }

    @Test
    fun getFirstElementOfStringPool() {
        val element = StringPool.get()
        Assert.assertEquals("A", element)
    }
}