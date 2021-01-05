package com.saman.tutorial.shop.service

import com.saman.tutorial.shop.domain.*
import com.saman.tutorial.shop.model.OrderModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.math.BigDecimal

class OrderServiceTest {

    private val service: OrderService = OrderService

    companion object {
        val TEST_DATA: MutableMap<String, AbstractModel<Int?>> = mutableMapOf()
    }

    init {
        val group = Group.Builder().name("Bread").build()
        TEST_DATA["bread"] = group

        val vegemite = Product.Builder(group)
            .name("Vegemite")
            .code("VS5")
            .price(BigDecimal.valueOf(2.33))
            .build()
        Pack.Builder(vegemite).qty(3).price(BigDecimal.valueOf(6.99)).build()
        Pack.Builder(vegemite).qty(5).price(BigDecimal.valueOf(8.99)).build()
        TEST_DATA["vegemite"] = vegemite

        val blueberryMuffin = Product.Builder(group)
            .name("Blueberry Muffin")
            .code("MB11")
            .price(BigDecimal.valueOf(4.50))
            .build()
        Pack.Builder(blueberryMuffin).qty(2).price(BigDecimal.valueOf(9.95)).build()
        Pack.Builder(blueberryMuffin).qty(5).price(BigDecimal.valueOf(16.95)).build()
        Pack.Builder(blueberryMuffin).qty(8).price(BigDecimal.valueOf(24.95)).build()
        TEST_DATA["blueberryMuffin"] = blueberryMuffin

        val croissant = Product.Builder(group)
            .name("Croissant")
            .code("CF")
            .price(BigDecimal.valueOf(2.00))
            .build()
        Pack.Builder(croissant).qty(3).price(BigDecimal.valueOf(5.95)).build()
        Pack.Builder(croissant).qty(5).price(BigDecimal.valueOf(9.95)).build()
        Pack.Builder(croissant).qty(9).price(BigDecimal.valueOf(16.99)).build()
        TEST_DATA["croissant"] = croissant
    }

    @Before
    fun setUp() {
        assertNotNull(service)
    }

    @Test
    fun calculate() {
        val order: Order = Order.Builder().build()
        OrderItem.Builder(order, TEST_DATA["vegemite"] as Product).qty(10).build()
        OrderItem.Builder(order, TEST_DATA["blueberryMuffin"] as Product).qty(14).build()
        OrderItem.Builder(order, TEST_DATA["croissant"] as Product).qty(13).build()

        val result: OrderModel = OrderService.calculate(order)
        assertNotNull(result)

        val vegemite = result.getItemByCode("VS5")
        assertEquals(10, vegemite.qty)
        assertEquals(BigDecimal.valueOf(17.98), vegemite.sum)
        assertEquals(1, vegemite.packs.size)
        assertEquals(2, vegemite.packs[0].count)
        assertEquals(5, vegemite.packs[0].pack.qty)
        assertEquals(BigDecimal.valueOf(8.99), vegemite.packs[0].pack.price)

        val blueberryMuffin = result.getItemByCode("MB11")
        assertEquals(14, blueberryMuffin.qty)
        assertEquals(BigDecimal.valueOf(5380, 2), blueberryMuffin.sum)
        assertEquals(2, blueberryMuffin.packs.size)
        assertEquals(2, blueberryMuffin.packs[0].count)
        assertEquals(5, blueberryMuffin.packs[0].pack.qty)
        assertEquals(BigDecimal.valueOf(16.95), blueberryMuffin.packs[0].pack.price)
        assertEquals(2, blueberryMuffin.packs[1].count)
        assertEquals(2, blueberryMuffin.packs[1].pack.qty)
        assertEquals(BigDecimal.valueOf(9.95), blueberryMuffin.packs[1].pack.price)

        val croissant = result.getItemByCode("CF")
        assertEquals(13, croissant.qty)
        assertEquals(BigDecimal.valueOf(25.85), croissant.sum)
        assertEquals(2, croissant.packs.size)
        assertEquals(2, croissant.packs[0].count)
        assertEquals(5, croissant.packs[0].pack.qty)
        assertEquals(BigDecimal.valueOf(9.95), croissant.packs[0].pack.price)
        assertEquals(1, croissant.packs[1].count)
        assertEquals(3, croissant.packs[1].pack.qty)
        assertEquals(BigDecimal.valueOf(5.95), croissant.packs[1].pack.price)

        println("\ninput:\n$order\n\noutput:\n$result")
    }
}