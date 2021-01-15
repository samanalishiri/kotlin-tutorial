package com.saman.tutorial.shop.domain

import org.junit.Assert.*
import org.junit.Test

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class GroupTest {

    @Test
    fun test001_GivenName_WhenBuildNewGroup_ThenReturnGroup() {
        val group: Group = Group.Builder().name("Furniture").build()
        assertNotNull(group)
        assertNull(group.identity)
        assertEquals(0, group.version)
        assertEquals("Furniture", group.name)
    }
}