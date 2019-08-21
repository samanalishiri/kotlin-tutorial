package com.saman.tutorial.kotlin.collection

import com.saman.tutorial.kotlin.collection.NumberArray.Companion.arrayOfInts
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import java.util.logging.Logger

class ArrayTest {

    val LOG = Logger.getLogger(ArrayTest::class.java.simpleName);

    @Test
    fun createEmptyArray() {
        val collection = NumberArray()
        assertThat(collection.getAll(), `is`(arrayOfInts(10)))
    }

    @Test
    fun addOneElement() {
        val collection = NumberArray()
        collection.add(1)

        assertThat(collection.getAll(), `is`(arrayOfInts(10, 1)))
    }

    @Test
    fun addElementOverTheSizeOfCurrentCollection() {
        val collection = NumberArray()

        (0 until 11).forEach { item -> collection.add(item) }

        assertEquals(20, collection.getSize())
    }



}