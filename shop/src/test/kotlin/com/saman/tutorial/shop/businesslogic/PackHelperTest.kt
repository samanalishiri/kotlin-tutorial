package com.saman.tutorial.shop.businesslogic

import com.saman.tutorial.shop.domain.*
import com.saman.tutorial.shop.model.OrderModel
import com.saman.tutorial.shop.service.OrderService
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal

class PackHelperTest {

    private val helper: PackHelper = PackHelper()

    @Before
    fun setUp() {
        assertNotNull(helper)
    }

    @Test
    fun calculateTotalPrice() {

        val group = Group.Builder().name("Bread").build()

        val vegemite = Product.Builder(group)
            .name("Vegemite")
            .code("VS5")
            .price(BigDecimal.valueOf(2.33))
            .build()
        Pack.Builder(vegemite).qty(3).price(BigDecimal.valueOf(6.99)).build()
        Pack.Builder(vegemite).qty(5).price(BigDecimal.valueOf(8.99)).build()

        val blueberryMuffin = Product.Builder(group)
            .name("Blueberry Muffin")
            .code("MB11")
            .price(BigDecimal.valueOf(4.50))
            .build()
        Pack.Builder(blueberryMuffin).qty(2).price(BigDecimal.valueOf(9.95)).build()
        Pack.Builder(blueberryMuffin).qty(5).price(BigDecimal.valueOf(16.95)).build()
        Pack.Builder(blueberryMuffin).qty(8).price(BigDecimal.valueOf(24.95)).build()

        val croissant = Product.Builder(group)
            .name("Croissant")
            .code("CF")
            .price(BigDecimal.valueOf(2.00))
            .build()
        Pack.Builder(croissant).qty(3).price(BigDecimal.valueOf(5.95)).build()
        Pack.Builder(croissant).qty(5).price(BigDecimal.valueOf(9.95)).build()
        Pack.Builder(croissant).qty(9).price(BigDecimal.valueOf(16.99)).build()


        val order: Order = Order.Builder().build()
        OrderItem.Builder(order, vegemite)
            .qty(10)
            .build()
        OrderItem.Builder(order, blueberryMuffin)
            .qty(14)
            .build()
        OrderItem.Builder(order, croissant)
            .qty(13)
            .build()

        val dto: OrderModel = OrderService.calculate(order)
        assertNotNull(dto)

        println("\ninput:\n$order\noutput:\n$dto")

    }

    @Test
    fun totalQuantity() {
    }
}