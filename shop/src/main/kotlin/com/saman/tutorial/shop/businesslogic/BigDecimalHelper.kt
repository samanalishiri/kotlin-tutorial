package com.saman.tutorial.shop.businesslogic

import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class BigDecimalHelper private constructor(private val number: BigDecimal) {
    /**
     * @param number
     * @return
     */
    fun isLessThanOrEquals(number: BigDecimal?): Boolean {
        return this.number.compareTo(number) < 1
    }

    companion object {
        /**
         * @param number
         * @return
         */
        fun of(number: BigDecimal): BigDecimalHelper {
            return BigDecimalHelper(number)
        }
    }
}