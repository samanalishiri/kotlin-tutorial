package com.saman.tutorial.kotlin.oop

import com.saman.tutorial.kotlin.oop.MessagePrinter
import org.junit.Test

class MessagePrinterTest {

    @Test
    internal fun testPrintAMessage() {
        MessagePrinter(arrayOf("A","B","C","D"))
                .print()
    }
}