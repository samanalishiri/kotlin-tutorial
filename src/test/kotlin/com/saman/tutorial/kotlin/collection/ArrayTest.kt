package com.saman.tutorial.kotlin.collection

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test

class ArrayTest {

    @Test
    fun createEmptyArray() {
        val collection = ArrayCollection()
        assertEquals(collection.getSize(), 0)
    }

    @Test
    fun addOneElement() {
        val collection = ArrayCollection()
        collection.add(1)

        assertThat(collection.getAll(), `is`(arrayOf(1)))
    }

    @Test
    fun addElementOverTheSizeOfCurrentCollection() {
        val collection = ArrayCollection()
        collection.add(1)
        collection.add(2)

        assertThat(collection.getAll(), `is`(arrayOf(1, 2)))
    }
}