package com.saman.tutorial.kotlin

fun main(args: Array<String>) {

    print("Enter your name:")
    val name: String? = readLine()
    name?.let { s -> println("Hello $s")}?: run { println("Hello every body") }
}

