package com.saman.tutorial.shop.domain

import java.util.concurrent.atomic.AtomicInteger

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
val GROUP_SEQUENCE: AtomicInteger = AtomicInteger(1)

val PRODUCT_SEQUENCE: AtomicInteger = AtomicInteger(1)

val PACK_SEQUENCE: AtomicInteger = AtomicInteger(1)

val ORDER_SEQUENCE: AtomicInteger = AtomicInteger(1)

val ORDER_ITEM_SEQUENCE: AtomicInteger = AtomicInteger(1)

val PRODUCT_DISCOUNT_SEQUENCE: AtomicInteger = AtomicInteger(1)

val PACK_DISCOUNT_SEQUENCE: AtomicInteger = AtomicInteger(1)