package com.saman.tutorial.shop.model

import com.saman.tutorial.shop.utils.CollectionUtils.Companion.joinString
import com.saman.tutorial.shop.utils.CollectionUtils.Companion.mapTo
import java.util.function.Function

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderModel(private val items: MutableList<OrderItemModel> = mutableListOf()) {

    fun addItem(vararg item: OrderItemModel): OrderModel {
        items.addAll(item)
        return this
    }

    fun getItemByCode(code: String) = items.stream().filter { it.code == code }.findFirst().get()

    override fun toString() = joinString(mapTo(items, Function { it.toString() }))
}