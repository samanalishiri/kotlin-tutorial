package com.saman.tutorial.kotlin

import org.junit.Test

class HelloTest {

    @Test
    fun testPrintHelloWithDefaultName() {
        hello()
    }

    @Test
    fun testPrintHelloWithWorldName() {
        hello("World")
    }
}
