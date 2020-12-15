package com.saman.tutorial.shop.model

import org.junit.Assert
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
                .group(Group.Builder().build())
                .build()

        assertNotNull(goods)
        Assert.assertNull(goods.id)
        assertEquals(0, goods.version)
        assertEquals("Chair", goods.name)
        assertEquals("001", goods.code)
        assertEquals(BigDecimal.valueOf(2050, 2), goods.price)
        assertNotNull(goods.group)
    }
}