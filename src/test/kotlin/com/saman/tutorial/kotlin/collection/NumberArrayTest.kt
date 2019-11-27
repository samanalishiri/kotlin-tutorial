package com.saman.tutorial.kotlin.collection

import com.saman.tutorial.kotlin.collection.NumberArray.Companion.arrayOfInts
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import java.util.logging.Logger

class NumberArrayTest {

    val LOG = Logger.getLogger(NumberArrayTest::class.java.simpleName);

    @Test
    fun whenCreateEmptyArray_thenReturnArrayWithTenNullObject() {
        val collection = NumberArray()
        assertThat(collection.getAll(), `is`(arrayOfInts(10)))
    }

    @Test
    fun whenAddOneElement_thenReturnArrayWithOneElementAndNineNullObject() {
        val collection = NumberArray()
        collection.add(1)

        assertThat(collection.getAll(), `is`(arrayOfInts(10, 1)))
    }

    @Test
    fun whenAddOneElementOverTheSizeOfCurrentCollection_thenCreateArrayWithOldElementsAndNewElementAndNineNullObject() {
        val collection = NumberArray()

        (0 until 11).forEach(action = collection::add)

        assertEquals(20, collection.getSize())
        assertThat(collection.getAll(), `is`(arrayOfInts(20, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    }


}