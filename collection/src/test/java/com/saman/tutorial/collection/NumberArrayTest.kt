package com.saman.tutorial.collection

import com.saman.tutorial.collection.NumberArray.Companion.arrayOfInts
import org.hamcrest.CoreMatchers
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test

class NumberArrayTest {
    @Test
    fun whenCreateEmptyArray_thenReturnArrayWithTenNullObject() {
        val collection = NumberArray()
        assertEquals(10, collection.getSize())
        assertEquals(-1, collection.lastIndex())
        assertThat(collection.getAll(), CoreMatchers.`is`(arrayOfInts(10)))
    }

    @Test
    fun whenAddOneElement_thenReturnArrayWithOneElementAndNineNullObject() {
        val collection = NumberArray()
        collection.add(1)

        assertEquals(10, collection.getSize())
        assertEquals(0, collection.lastIndex())
        assertThat(collection.getAll(), CoreMatchers.`is`(arrayOfInts(10, 1)))
    }

    @Test
    fun whenAddOneElementOverTheSizeOfCurrentCollection_thenCreateArrayWithOldElementsAndNewElementAndNineNullObject() {
        val collection = NumberArray()

        (0 until 11).forEach(action = collection::add)

        assertEquals(20, collection.getSize())
        assertEquals(10, collection.lastIndex())
        assertThat(collection.getAll(), CoreMatchers.`is`(arrayOfInts(20, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    }

}