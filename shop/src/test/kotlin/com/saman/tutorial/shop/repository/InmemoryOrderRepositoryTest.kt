package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.AbstractTest
import com.saman.tutorial.shop.domain.*
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import java.math.BigDecimal
import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class InmemoryOrderRepositoryTest : AbstractTest() {

    companion object {
        val TEST_DATA: MutableMap<String, AbstractModel<Int?>> = mutableMapOf()
    }

    init {
        val group = Group.Builder().name("Furniture").build()
        InmemoryGroupRepository.save(group)
        TEST_DATA["furniture"] = group

        var chair: Product = Product.buildEmpty()
        chair = Product.Builder(group).name("Chair")
            .code("001")
            .price(BigDecimal.valueOf(578, 1))
            .packs(
                Pack.Builder(chair)
                    .qty(4)
                    .price(BigDecimal.valueOf(220))
                    .build()
            )
            .build()
        InmemoryProductRepository.save(chair)
        TEST_DATA["chair"] = chair

        var table: Product = Product.buildEmpty()
        table = Product.Builder(group)
            .name("Table")
            .code("002")
            .price(BigDecimal.valueOf(14999, 2))
            .packs(
                Pack.Builder(table)
                    .qty(2)
                    .price(BigDecimal.valueOf(290))
                    .build()
            )
            .build()
        InmemoryProductRepository.save(table)
        TEST_DATA["table"] = table
    }

    private val repository = InmemoryOrderRepository

    @Before
    fun beforeTest() {
        assertNotNull(repository)
    }

    @Test
    fun test001_save_GivenOrder_WhenSaveNewOrder_ThenReturnIdentity() {
        assertNotNull(TEST_DATA["chair"])
        val chair: Product = TEST_DATA["chair"] as Product

        assertNotNull(TEST_DATA["table"])
        val table: Product = TEST_DATA["table"] as Product

        var order: Order = Order.Builder().build()
        OrderItem.Builder(order, chair).qty(6).build()
        OrderItem.Builder(order, table).qty(1).build()

        val identity: Optional<Int?> = repository.save(order)
        Assert.assertTrue(identity.isPresent)
        assertNotNull(identity.get())

        TEST_DATA["order"] = order
    }
}