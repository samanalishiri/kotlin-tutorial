package com.saman.tutorial.shop.utils

import java.math.BigDecimal
import java.text.NumberFormat.getCurrencyInstance
import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class CurrencyUtils private constructor() {

    companion object {
        fun convertToMoneyFormat(num: BigDecimal): String {
            val format = getCurrencyInstance(Locale.US)
            return format.format(num)
        }
    }
}