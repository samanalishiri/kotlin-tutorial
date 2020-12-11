package com.saman.tutorial.shop.model

import java.util.concurrent.atomic.AtomicInteger

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
interface KeySequences {

    companion object {
        val GROUP_SEQUENCE: AtomicInteger = AtomicInteger(1);

        val GOODS_SEQUENCE: AtomicInteger = AtomicInteger(1);

    }
}