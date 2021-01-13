package com.saman.tutorial.shop.domain

import org.junit.Assert.*
import org.junit.Test

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderItemTest {

    @Test
    fun test001_GivenName_WhenBuildNewOrderItem_ThenReturnOrderItem() {
        val order = Order.Builder().build()
        val product = Product.Builder(Group.Builder().build()).build()
        val orderItem = OrderItem.Builder(order, product)
            .qty(2)
            .build()

        assertNotNull(orderItem)
        assertNull(orderItem.id)
        assertEquals(0, orderItem.version)
        assertEquals(2, orderItem.qty)
        assertNotNull(orderItem.product)
    }

}