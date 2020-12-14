package com.saman.tutorial.shop.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class GoodsTest {
    @Test
    fun test001_GivenParams_WhenBuildNewGoods_ThenReturnGoods() {
        val goods: Goods = Goods.Builder()
                .name("Chair")
                .code("001")
                .price(BigDecimal.valueOf(2050, 2))
                .group(Group.Builder().name("Furniture").build())
                .packs(Pack.Builder().qty(2).price(BigDecimal.valueOf(40)).build())
                .build()

        assertNotNull(goods)
        assertEquals("Chair", goods.name)
        assertEquals("001", goods.code)
        assertEquals(BigDecimal.valueOf(2050, 2), goods.price)
        assertNotNull(goods.group)
        assertNotNull(goods.packs)
        assertEquals(goods.packs.size, 1)
        assertEquals("Chair 001 [2 @ £40.00]", goods.toString())
    }
}