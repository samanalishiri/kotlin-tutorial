package com.saman.tutorial.kotlin.oop

interface Printer {
    fun print()
}

class Message(private val texts: Array<String> = emptyArray()) {

    fun concat(): String {
        return texts.joinToString(separator = ",")
    }
}

class ConsolePrinter(private val message: Message) : Printer {
    override fun print() {
        println(message.concat())
    }
}