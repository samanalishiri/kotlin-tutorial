package com.saman.tutorial.shop.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class GroupTest {

    @Test
    fun GivenName_WhenCreateNewGroup_ThenReturnGroup() {
        val group: Group = Group.Builder().name("Furniture").build()
        assertNull(group.id)
        assertEquals(0, group.version)
        assertEquals("Furniture", group.name)
    }

}