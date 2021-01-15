package com.saman.tutorial.shop.model

import com.saman.tutorial.shop.utils.convertAndJoinAsLine

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderModel(private val items: MutableList<OrderItemModel> = mutableListOf()) {

    @Suppress("unused")
    fun addItem(vararg item: OrderItemModel): OrderModel {
        items.addAll(item)
        return this
    }

    fun getItemByCode(code: String) = items.stream()
        .filter { it.item.product.code == code }
        .findFirst()
        .get()

    override fun toString() = convertAndJoinAsLine(items)
}