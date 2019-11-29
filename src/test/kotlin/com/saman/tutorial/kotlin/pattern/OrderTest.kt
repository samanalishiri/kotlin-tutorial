package com.saman.tutorial.kotlin.pattern

import com.saman.tutorial.kotlin.pattern.Order.Companion.IS_HANDED_OVER_STATUS
import com.saman.tutorial.kotlin.pattern.Order.Companion.ORDERING_STATUS
import org.junit.Assert.assertEquals
import org.junit.Test

class OrderTest {

    @Test
    fun whenTheCustomerIsOrdering_thenReturnOrderingStatus() {
        val coffee = Order.Builder(table = 1)
                .menu("Coffee")
                .additional("More sugar")
                .build()

        assertEquals(1, coffee.menus.size)
        assertEquals(1, coffee.version)
        assertEquals(ORDERING_STATUS, coffee.status)
    }

    @Test
    fun whenTheCustomerOrderedTwoMenu_thenSizeOfMenuShouldBeTwo() {
        val tableOneIsOrdering = Order.Builder(table = 1)
                .menu("Coffee")
                .menu("Red Win")
                .additional("More sugar for coffee")
                .build()

        assertEquals(2, tableOneIsOrdering.menus.size)
        assertEquals(1, tableOneIsOrdering.version)
        assertEquals(ORDERING_STATUS, tableOneIsOrdering.status)
    }

    @Test
    fun whenTheCustomerGetTheOrder_thenReturnIsHandedOverStatus() {
        val coffee = Order.Builder(table = 1)
                .menu("Coffee")
                .additional("More sugar")
                .build()

        assertEquals(1, coffee.menus.size)
        assertEquals(1, coffee.version)
        assertEquals(ORDERING_STATUS, coffee.status)

        val wasHandedOverCoffee = coffee.isHandedOver()

        assertEquals(1, wasHandedOverCoffee.menus.size)
        assertEquals(2, wasHandedOverCoffee.version)
        assertEquals(IS_HANDED_OVER_STATUS, wasHandedOverCoffee.status)
    }
}