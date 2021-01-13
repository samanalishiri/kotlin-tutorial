package com.saman.tutorial.shop.domain

import org.junit.Assert.*
import org.junit.Test
import java.math.BigDecimal

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
        assertNull(pack.id)
        assertEquals(0, pack.version)
        assertEquals(2, pack.qty)
        assertEquals(BigDecimal.valueOf(40), pack.price)
        assertNotNull(pack.product)
    }

}