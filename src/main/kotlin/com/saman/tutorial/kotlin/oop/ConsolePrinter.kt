package com.saman.tutorial.kotlin.oop

class ConsolePrinter(private val message: Message): Printer {
    override fun print() {
        println(message.concat())
    }
}