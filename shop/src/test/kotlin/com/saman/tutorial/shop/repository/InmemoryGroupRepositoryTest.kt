package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.AbstractTest
import com.saman.tutorial.shop.domain.Group
import org.junit.Assert.*
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class InmemoryGroupRepositoryTest : AbstractTest() {

    companion object {
        val TEST_DATA: MutableMap<String, Group> = mutableMapOf()
    }

    private val repository = InmemoryGroupRepository

    @Before
    fun beforeTest() {
        assertNotNull(repository)
    }

    @Test
    fun test001_save_GivenGroup_WhenSaveNewGroup_ThenReturnIdentity() {
        val group: Group = Group.Builder().name("Furniture").build()

        val identity: Optional<Int?> = repository.save(group)
        assertTrue(identity.isPresent)
        assertNotNull(identity.get())
        TEST_DATA["furniture"] = Group.Builder().from(group).id(identity.get()).build()
    }

    @Test
    fun test002_findById_GivenIdAsParam_WhenFindById_ThenReturnGroup() {
        assertNotNull(TEST_DATA["furniture"])
        val testModel: Group = TEST_DATA["furniture"]!!

        val model: Optional<Group> = repository.findById(testModel.identity)
        assertTrue(model.isPresent)
        assertEquals(testModel.identity, model.get().identity)
        assertEquals(testModel.name, model.get().name)
        assertEquals(testModel.version, model.get().version)
    }

    @Test
    fun test003_update_GivenChangedData_WhenUpdate_ThenApplyNewChanges() {
        assertNotNull(TEST_DATA["furniture"])
        val testModel: Group = TEST_DATA["furniture"]!!
        val id = testModel.identity
        assertNotNull(id)

        val preUpdateModel: Optional<Group> = repository.findById(id)
        assertTrue(preUpdateModel.isPresent)
        val model: Group = Group.Builder().from(preUpdateModel.get()).name("Furniture_Updated").build()
        repository.update(id, model)

        val afterUpdateModel: Optional<Group> = repository.findById(id)
        assertTrue(afterUpdateModel.isPresent)
        assertEquals(testModel.identity, afterUpdateModel.get().identity)
        assertEquals(model.name, afterUpdateModel.get().name)
        assertEquals(testModel.version + 1, afterUpdateModel.get().version)
    }

    @Test
    fun test004_deleteById_GivenIdAsParam_WhenDeleteById_ThenDeleteFromStorage() {
        assertNotNull(TEST_DATA["furniture"])
        val testModel: Group = TEST_DATA["furniture"]!!
        val id = testModel.identity
        assertNotNull(id)

        repository.deleteById(id)
        val model: Optional<Group> = repository.findById(id)
        assertFalse(model.isPresent)
    }
}