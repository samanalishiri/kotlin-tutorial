package com.saman.tutorial.kotlin.pattern

import org.junit.Assert.assertEquals
import org.junit.Test

class PersonTest {
    @Test
    fun createManNameSaman() {
        val person: Person = Person.create(KindOfPerson.MALE, "Saman")

        assertEquals("Saman", person.getName())
    }
}