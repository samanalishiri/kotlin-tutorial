package com.saman.tutorial.kotlin.oop

import org.junit.Test
import kotlin.test.assertEquals

class ConsolePrinterTest {

    @Test
    internal fun whenGivenSomeMessages_thenReturnConcatMessage() {
        val message = Message(arrayOf("A", "B", "C", "D"))

        assertEquals(message.concat(), "A,B,C,D")
    }

    @Test
    internal fun whenGivenSomeMessages_thenPrintConcatMessage() {
        val message = Message(arrayOf("A", "B", "C", "D"))

        assertEquals(message.concat(), "A,B,C,D")
        ConsolePrinter(message).print()
    }
}