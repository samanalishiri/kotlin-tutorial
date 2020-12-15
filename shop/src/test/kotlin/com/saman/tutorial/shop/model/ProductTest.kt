package com.saman.tutorial.shop.model

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class ProductTest {
    @Test
    fun test001_GivenParams_WhenBuildNewProduct_ThenReturnProduct() {
        val product: Product = Product.Builder(Group.Builder().build())
                .name("Chair")
                .code("001")
                .price(BigDecimal.valueOf(2050, 2))
                .build()

        assertNotNull(product)
        Assert.assertNull(product.id)
        assertEquals(0, product.version)
        assertEquals("Chair", product.name)
        assertEquals("001", product.code)
        assertEquals(BigDecimal.valueOf(2050, 2), product.price)
        assertNotNull(product.group)
    }
}