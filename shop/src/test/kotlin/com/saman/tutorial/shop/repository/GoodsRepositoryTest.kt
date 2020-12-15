package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.AbstractTest
import com.saman.tutorial.shop.model.AbstractModel
import com.saman.tutorial.shop.model.Goods
import com.saman.tutorial.shop.model.Group
import com.saman.tutorial.shop.model.Pack
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
class GoodsRepositoryTest : AbstractTest() {

    companion object {
        val TEST_DATA: MutableMap<String, AbstractModel<Int?>> = mutableMapOf()

    }

    init {
        val groupId: Optional<Int?> = GroupRepository.save(Group.Builder()
                .name("Furniture")
                .build())
        assertTrue(groupId.isPresent)
        val group: Optional<Group> = GroupRepository.findById(groupId.get())
        assertTrue(group.isPresent)
        assertEquals("Furniture", group.get().name)
        assertEquals(0, group.get().version)

        TEST_DATA["furniture"] = group.get()
    }

    private val goodsRepository = GoodsRepository

    @Before
    fun beforeTest() {
        assertNotNull(goodsRepository)
    }

    @Test
    fun test001_save_GivenNewGoods_WhenSave_ThenReturnId() {
        val group: Group = TEST_DATA["furniture"] as Group

        val goods: Goods = Goods.Builder()
                .name("Chair")
                .code("001")
                .price(BigDecimal.valueOf(2050, 2))
                .group(group)
                .packs(Pack.Builder()
                        .qty(2)
                        .price(BigDecimal.valueOf(40))
                        .build())
                .build()

        val identity: Optional<Int?> = goodsRepository.save(goods)
        assertTrue(identity.isPresent)
        assertNotNull(identity.get())
        TEST_DATA["chair"] = goods
    }

    @Test
    fun test002_findById_GivenIdAsParam_WhenFindById_ThenReturnGoods() {
        assertNotNull(TEST_DATA["chair"])
        val testModel: Goods = TEST_DATA["chair"] as Goods

        val model: Optional<Goods> = goodsRepository.findById(testModel.id)
        assertTrue(model.isPresent)
        assertEquals(testModel.id, model.get().id)
        assertEquals(testModel.name, model.get().name)
        assertEquals(testModel.code, model.get().code)
        assertEquals(testModel.price, model.get().price)
        assertEquals(testModel.version, model.get().version)

        val group = model.get().group
        assertNotNull(group)
        assertNotNull(group.id)
        assertEquals("Furniture", group.name)
        assertEquals(0, group.version)

        val packs = model.get().packs
        assertEquals(1, packs.size)
        assertEquals(2, packs.get(0)?.qty)
        assertEquals(BigDecimal.valueOf(40), packs.get(0)?.price)
    }

    @Test
    fun test003_update_GivenChangedData_WhenUpdate_ThenApplyNewChanges() {
        assertNotNull(TEST_DATA["chair"])
        val testModel: Goods = TEST_DATA["chair"] as Goods
        val id = testModel.id
        assertNotNull(id)

        val preUpdateModel: Optional<Goods> = goodsRepository.findById(id)
        assertTrue(preUpdateModel.isPresent)
        val model: Goods = Goods.Builder().from(preUpdateModel.get()).name("Chair_Updated").build()
        goodsRepository.update(id, model)

        val afterUpdateModel: Optional<Goods> = goodsRepository.findById(id)
        assertTrue(afterUpdateModel.isPresent)
        assertEquals(testModel.id, afterUpdateModel.get().id)
        assertEquals(model.name, afterUpdateModel.get().name)
        assertEquals(testModel.code, afterUpdateModel.get().code)
        assertEquals(testModel.price, afterUpdateModel.get().price)
        assertEquals(testModel.version + 1, afterUpdateModel.get().version)
    }

    @Test
    fun test004_deleteById_GivenIdAsParam_WhenDeleteById_ThenDeleteFromStorage() {
        assertNotNull(TEST_DATA["chair"])
        val testModel: Goods = TEST_DATA["chair"] as Goods
        val id = testModel.id
        assertNotNull(id)

        goodsRepository.deleteById(id)
        val model: Optional<Goods> = goodsRepository.findById(id)
        assertFalse(model.isPresent)
    }
}