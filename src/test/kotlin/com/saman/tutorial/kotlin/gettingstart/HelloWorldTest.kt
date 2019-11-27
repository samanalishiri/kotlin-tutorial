package com.saman.tutorial.kotlin.gettingstart

import org.junit.Test

class HelloWorldTest {

    @Test
    fun testPrintHelloWithDefaultName() {
        hello()
    }

    @Test
    fun testPrintHelloWorldWithSpecificName() {
        hello("World")
    }
}
