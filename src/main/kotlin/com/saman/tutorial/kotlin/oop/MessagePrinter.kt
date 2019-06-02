package com.saman.tutorial.kotlin.oop

class MessagePrinter(texts: Array<String> = emptyArray()): Message(texts), Printer {
    override fun print() {
        println(concat())
    }
}