package com.saman.tutorial.shop.model

import com.saman.tutorial.shop.utils.CollectionUtils.Companion.joinString
import java.util.stream.Collectors.toList

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderModel(private val items: MutableList<OrderItemModel> = mutableListOf()) {

    fun addItem(vararg item: OrderItemModel): OrderModel {
        items.addAll(item)
        return this
    }

    fun getItemByCode(code: String) = items.stream().filter { it.code == code }.findFirst().get()

    override fun toString() = joinString(items.stream().map(OrderItemModel::toString).collect(toList()))
}