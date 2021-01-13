package com.saman.tutorial.shop.service

import com.saman.tutorial.shop.domain.*
import com.saman.tutorial.shop.model.PackModel
import com.saman.tutorial.shop.utils.CollectionUtils
import com.saman.tutorial.shop.utils.CollectionUtils.Companion.joinString
import com.saman.tutorial.shop.utils.CollectionUtils.Companion.mapTo
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.runners.MethodSorters
import java.math.BigDecimal
import java.util.function.Function

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class OrderItemServiceTest {
    private val service: OrderItemService = OrderItemService

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
    fun test001_Given10VegemiteAsOrder_WhenFindMinimumPacks_ThenReturnTwo5Pack() {
        val product = TEST_DATA["vegemite"] as Product
        val order = Order.creatEmpty()
        val orderItem: OrderItem = OrderItem.Builder(order, product)
            .qty(10)
            .build()

        val result: List<PackModel> = OrderItemService.findMinimumPacks(orderItem)

        assertNotNull(result)
        assertEquals(10, orderItem.qty)
        assertEquals(1, result.size)
        assertEquals(2, result[0].count)
        assertEquals(5, result[0].pack.qty)
        assertEquals(BigDecimal.valueOf(8.99), result[0].pack.price)

        println(joinString(mapTo(result, Function { it.toString() })))
    }

    @Test
    fun test002_Given14BlueberryMuffinAsOrder_WhenFindMinimumPacks_ThenReturnTwo5PackAndTwo2Pack() {
        val product = TEST_DATA["blueberryMuffin"] as Product
        val order = Order.creatEmpty()
        val orderItem: OrderItem = OrderItem.Builder(order, product)
            .qty(14)
            .build()

        val result: List<PackModel> = OrderItemService.findMinimumPacks(orderItem)

        assertNotNull(result)
        assertEquals(14, orderItem.qty)
        assertEquals(2, result.size)
        assertEquals(2, result[0].count)
        assertEquals(5, result[0].pack.qty)
        assertEquals(BigDecimal.valueOf(16.95), result[0].pack.price)
        assertEquals(2, result[1].count)
        assertEquals(2, result[1].pack.qty)
        assertEquals(BigDecimal.valueOf(9.95), result[1].pack.price)

        println(joinString(mapTo(result, Function { it.toString() })))
    }

    @Test
    fun test003_Given13CroissantAsOrder_WhenFindMinimumPacks_ThenReturnTwo5PackAndOne3Pack() {
        val product = TEST_DATA["croissant"] as Product
        val order = Order.creatEmpty()
        val orderItem: OrderItem = OrderItem.Builder(order, product)
            .qty(13)
            .build()

        val result: List<PackModel> = OrderItemService.findMinimumPacks(orderItem)

        assertNotNull(result)
        assertEquals(13, orderItem.qty)
        assertEquals(2, result.size)
        assertEquals(2, result[0].count)
        assertEquals(5, result[0].pack.qty)
        assertEquals(BigDecimal.valueOf(9.95), result[0].pack.price)
        assertEquals(1, result[1].count)
        assertEquals(3, result[1].pack.qty)
        assertEquals(BigDecimal.valueOf(5.95), result[1].pack.price)

        println(joinString(mapTo(result, Function { it.toString() })))
    }

}