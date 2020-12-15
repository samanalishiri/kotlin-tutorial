package com.saman.tutorial.shop.model

import java.util.concurrent.atomic.AtomicInteger

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
interface KeySequences {

    companion object {
        val GROUP_SEQUENCE: AtomicInteger = AtomicInteger(1);

        val PRODUCT_SEQUENCE: AtomicInteger = AtomicInteger(1);

        val PACK_SEQUENCE: AtomicInteger = AtomicInteger(1);

    }
}