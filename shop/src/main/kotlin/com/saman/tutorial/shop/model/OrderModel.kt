package com.saman.tutorial.shop.model

import com.saman.tutorial.shop.utils.CollectionUtils.Companion.multiLine
import java.util.stream.Collectors.toList

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderModel {

    private val items: MutableList<OrderItemModel> = mutableListOf()

    fun addItem(item: OrderItemModel) {
        items.add(item)
    }

    override fun toString(): String = multiLine(items.stream().map(OrderItemModel::toString).collect(toList()))
}