package com.saman.tutorial.kotlin

import com.saman.tutorial.kotlin.gettingstart.hello
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
