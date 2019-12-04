package com.saman.tutorial.kotlin.pattern

enum class KindOfPerson {
    MALE, FEMALE
}

class Person internal constructor(private val kind: KindOfPerson) {

    private var name: String = ""

    companion object {
        fun create(kind: KindOfPerson, name: String): Person {
            return Person(kind).setName(name)
        }
    }

    fun setName(name: String): Person {
        this.name = name
        return this
    }

    fun getName(): String {
        return name
    }

    fun isMan(): Boolean {
        return KindOfPerson.MALE == this.kind
    }

    fun isFemale(): Boolean {
        return KindOfPerson.FEMALE == this.kind
    }
}
