package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.domain.KeySequences
import com.saman.tutorial.shop.domain.OrderItem

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object InmemoryOrderItemRepository : AbstractRepository<Int?, OrderItem, OrderItem.Builder>() {
    override fun getMapName(): String {
        return OrderItem.MAP_NAME
    }

    override fun getBuilder(item: OrderItem): OrderItem.Builder {
        return OrderItem.Builder(item.order, item.product)
    }

    override fun nextId(): Int {
        return KeySequences.ORDER_ITEM_SEQUENCE.getAndIncrement()
    }
}