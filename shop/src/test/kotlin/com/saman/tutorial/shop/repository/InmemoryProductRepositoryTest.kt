package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.AbstractTest
import com.saman.tutorial.shop.domain.AbstractModel
import com.saman.tutorial.shop.domain.Group
import com.saman.tutorial.shop.domain.Pack
import com.saman.tutorial.shop.domain.Product
import org.junit.Assert.*
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import java.math.BigDecimal
import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class InmemoryProductRepositoryTest : AbstractTest() {

    companion object {
        val TEST_DATA: MutableMap<String, AbstractModel<Int?>> = mutableMapOf()
    }

    init {
        val groupId: Optional<Int?> = InmemoryGroupRepository.save(
            Group.Builder()
                .name("Furniture")
                .build()
        )
        assertTrue(groupId.isPresent)
        val group: Optional<Group> = InmemoryGroupRepository.findById(groupId.get())
        assertTrue(group.isPresent)
        assertEquals("Furniture", group.get().name)
        assertEquals(0, group.get().version)

        TEST_DATA["furniture"] = group.get()
    }

    private val productRepository = InmemoryProductRepository

    @Before
    fun beforeTest() {
        assertNotNull(productRepository)
    }

    @Test
    fun test001_save_GivenNewProduct_WhenSave_ThenReturnId() {
        val group: Group = TEST_DATA["furniture"] as Group
        assertNotNull(group)

        val product = Product.Builder(group)
            .name("Chair")
            .code("001")
            .price(BigDecimal.valueOf(2050, 2))
            .build()

        Pack.Builder(product)
            .qty(2)
            .price(BigDecimal.valueOf(40))
            .build()

        val identity: Optional<Int?> = productRepository.save(product)
        assertTrue(identity.isPresent)
        assertNotNull(identity.get())
        TEST_DATA["chair"] = product
    }

    @Test
    fun test002_findById_GivenIdAsParam_WhenFindById_ThenReturnProduct() {
        assertNotNull(TEST_DATA["chair"])
        val testModel: Product = TEST_DATA["chair"] as Product

        val model: Optional<Product> = productRepository.findById(testModel.identity)
        assertTrue(model.isPresent)
        assertEquals(testModel.identity, model.get().identity)
        assertEquals(testModel.name, model.get().name)
        assertEquals(testModel.code, model.get().code)
        assertEquals(testModel.price, model.get().price)
        assertEquals(testModel.version, model.get().version)

        val group = model.get().group
        assertNotNull(group)
        assertNotNull(group.identity)
        assertEquals("Furniture", group.name)
        assertEquals(0, group.version)

        val packs = model.get().packs
        assertEquals(1, packs.size)
        assertEquals(2, packs[0].qty)
        assertEquals(BigDecimal.valueOf(40), packs[0].price)
    }

    @Test
    fun test003_update_GivenChangedData_WhenUpdate_ThenApplyNewChanges() {
        assertNotNull(TEST_DATA["chair"])
        val testModel: Product = TEST_DATA["chair"] as Product
        val id = testModel.identity
        assertNotNull(id)

        assertNotNull(TEST_DATA["furniture"])
        val group: Group = TEST_DATA["furniture"] as Group

        val preUpdateModel: Optional<Product> = productRepository.findById(id)
        assertTrue(preUpdateModel.isPresent)
        val model: Product = Product.Builder(group).from(preUpdateModel.get()).name("Chair_Updated").build()
        productRepository.update(id, model)

        val afterUpdateModel: Optional<Product> = productRepository.findById(id)
        assertTrue(afterUpdateModel.isPresent)
        assertEquals(testModel.identity, afterUpdateModel.get().identity)
        assertEquals(model.name, afterUpdateModel.get().name)
        assertEquals(testModel.code, afterUpdateModel.get().code)
        assertEquals(testModel.price, afterUpdateModel.get().price)
        assertEquals(testModel.version + 1, afterUpdateModel.get().version)
    }

    @Test
    fun test004_deleteById_GivenIdAsParam_WhenDeleteById_ThenDeleteFromStorage() {
        assertNotNull(TEST_DATA["chair"])
        val testModel: Product = TEST_DATA["chair"] as Product
        val id = testModel.identity
        assertNotNull(id)

        productRepository.deleteById(id)
        val model: Optional<Product> = productRepository.findById(id)
        assertFalse(model.isPresent)
    }
}