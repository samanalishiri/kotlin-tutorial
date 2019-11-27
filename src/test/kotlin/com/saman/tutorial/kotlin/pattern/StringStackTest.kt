package com.saman.tutorial.kotlin.pattern

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class StringStackTest {

    @Before
    fun setUp() {
        StringStack.clear()
    }

    @Test
    fun whenAddOneElements_thenTheSizeMustBeOne() {
        StringStack.add("A")

        assertEquals(1, StringStack.size())
    }

    @Test
    fun whenAddTwoElements_thenReturnFirstElement() {
        StringStack.add("A")
        StringStack.add("B")

        val element = StringStack.get()

        Assert.assertEquals("B", element)
    }
}