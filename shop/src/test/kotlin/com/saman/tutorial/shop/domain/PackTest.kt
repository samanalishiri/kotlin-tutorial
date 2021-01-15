package com.saman.tutorial.shop.domain

import org.junit.Assert.*
import org.junit.Test
import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class PackTest {

    @Test
    fun test001_GivenName_WhenBuildNewPack_ThenReturnPack() {
        val group = Group.Builder().build()
        val product = Product.Builder(group).build()
        val pack: Pack = Pack.Builder(product)
            .qty(2)
            .price(BigDecimal.valueOf(40))
            .build()

        assertNotNull(pack)
        assertNull(pack.identity)
        assertEquals(0, pack.version)
        assertEquals(2, pack.qty)
        assertEquals(BigDecimal.valueOf(40), pack.price)
        assertNotNull(pack.product)
        assertTrue(group == product.group)
        assertTrue(product == pack.product)
        assertTrue(group == pack.product.group)
    }
}