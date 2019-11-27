package com.saman.tutorial.kotlin.pattern

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class stackTest {

    @Before
    fun setUp() {
        stack.clear()
    }

    @Test
    fun whenAddOneElements_thenTheSizeMustBeOne() {
        stack.add("A")

        assertEquals(1, stack.size())
    }

    @Test
    fun whenAddTwoElements_thenReturnFirstElement() {
        stack.add("A")
        stack.add("B")

        val element = stack.get()

        Assert.assertEquals("B", element)
    }
}