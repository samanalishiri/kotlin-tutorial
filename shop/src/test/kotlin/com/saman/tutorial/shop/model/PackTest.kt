package com.saman.tutorial.shop.model

import org.junit.Assert.*
import org.junit.Test
import java.math.BigDecimal

class PackTest {

    @Test
    fun test001_GivenName_WhenBuildNewPack_ThenReturnPack() {
        val pack: Pack = Pack.Builder(Product.Builder(Group.Builder().build()).build())
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