package com.saman.tutorial.kotlin.oop

import org.junit.Test
import kotlin.test.assertEquals

class ConsolePrinterTest {

    @Test
    internal fun testPrintAMessage() {
        val message = Message(arrayOf("A", "B", "C", "D"))

        assertEquals(message.concat(), "A,B,C,D")

        ConsolePrinter(message).print()
    }
}