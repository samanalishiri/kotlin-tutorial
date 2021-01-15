package com.saman.tutorial.shop.businesslogic

import com.saman.tutorial.shop.domain.AbstractModel
import com.saman.tutorial.shop.domain.Group
import com.saman.tutorial.shop.domain.Pack
import com.saman.tutorial.shop.domain.Product
import com.saman.tutorial.shop.model.PackModel
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class PackHelperTest {

    companion object {
        val TEST_DATA: MutableMap<String, AbstractModel<Int?>> = mutableMapOf()
    }

    init {
        val group = Group.Builder().name("Bread").build()
        TEST_DATA["bread"] = group

        val blueberryMuffin = Product.Builder(group)
            .name("Blueberry Muffin")
            .code("MB11")
            .price(BigDecimal.valueOf(4.50))
            .build()
        Pack.Builder(blueberryMuffin).qty(2).price(BigDecimal.valueOf(9.95)).build()
        Pack.Builder(blueberryMuffin).qty(5).price(BigDecimal.valueOf(16.95)).build()
        Pack.Builder(blueberryMuffin).qty(8).price(BigDecimal.valueOf(24.95)).build()
        TEST_DATA["blueberryMuffin"] = blueberryMuffin
    }

    @Test
    fun test_GivenListOfPack_WhenCalculateTotalPrice_ThenReturnTotalPriceAsBigDecimalNumber() {
        val product = TEST_DATA["blueberryMuffin"] as Product
        val totalPrice = totalPrice(listOf(PackModel(2, product.packs[0]), PackModel(2, product.packs[1])))
        assertEquals(BigDecimal.valueOf(5380, 2), totalPrice)
    }

    @Test
    fun test_GivenListOfPack_WhenCalculateTotalCount_ThenReturnTotalPacksAsIntegerNumber() {
        val product = TEST_DATA["blueberryMuffin"] as Product
        val totalCount = totalCount(listOf(PackModel(2, product.packs[0]), PackModel(2, product.packs[1])))
        assertEquals(4, totalCount)
    }
}