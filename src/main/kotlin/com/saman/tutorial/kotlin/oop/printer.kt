package com.saman.tutorial.kotlin.oop

interface Printer {
    fun print()
}

data class Message(private val texts: Array<String> = emptyArray()) {

    override fun toString(): String {
        return texts.joinToString(separator = ",")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Message

        if (!texts.contentEquals(other.texts)) return false

        return true
    }

    override fun hashCode(): Int {
        return texts.contentHashCode()
    }
}

class ConsolePrinter(private val message: Message) : Printer {
    override fun print() {
        println(message)
    }
}