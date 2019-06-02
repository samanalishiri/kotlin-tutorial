package com.saman.tutorial.kotlin.oop

open class Message(private val texts: Array<String> = emptyArray()) {

    fun concat():String {
        return texts.joinToString(separator = ",")
    }
}