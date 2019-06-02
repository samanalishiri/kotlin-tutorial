package com.saman.tutorial.kotlin

fun hello(name: String? = null) {
    name?.let { s -> println("Hello $s")}?: run { println("Hello every body") }
}

