package com.saman.tutorial.kotlin.oop

class Message(private val texts: Array<String> = emptyArray()) {

    fun concat():String {
        return texts.joinToString(separator = ",")
    }
}