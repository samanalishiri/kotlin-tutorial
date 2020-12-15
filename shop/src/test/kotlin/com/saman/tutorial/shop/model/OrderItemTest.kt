package com.saman.tutorial.shop.model

import org.junit.Assert.*
import org.junit.Test

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderItemTest {

    @Test
    fun test001_GivenName_WhenBuildNewOrderItem_ThenReturnOrderItem() {
        val orderItem: OrderItem = OrderItem.Builder(Product.Builder(Group.Builder().build()).build())
                .qty(2)
                .build()

        assertNotNull(orderItem)
        assertNull(orderItem.id)
        assertEquals(0, orderItem.version)
        assertEquals(2, orderItem.qty)
        assertNotNull(orderItem.product)
    }

}