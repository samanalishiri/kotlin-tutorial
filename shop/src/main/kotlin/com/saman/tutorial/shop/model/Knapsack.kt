package com.saman.tutorial.shop.model

import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
interface Knapsack {
    fun getWeight(): Int

    fun getValue(): BigDecimal
}