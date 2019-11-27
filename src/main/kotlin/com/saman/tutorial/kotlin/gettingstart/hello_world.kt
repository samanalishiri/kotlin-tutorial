package com.saman.tutorial.kotlin.gettingstart

fun hello(name: String? = null) {
    name?.let { s -> println("Hello $s")}?: run { println("Hello every body") }
}

