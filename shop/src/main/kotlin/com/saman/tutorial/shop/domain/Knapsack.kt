package com.saman.tutorial.shop.domain

import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
interface Knapsack {
    fun getWeight(): Int

    fun getValue(): BigDecimal
}