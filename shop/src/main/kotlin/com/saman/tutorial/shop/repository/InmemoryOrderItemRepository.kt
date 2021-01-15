package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.domain.ORDER_ITEM_SEQUENCE
import com.saman.tutorial.shop.domain.OrderItem

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object InmemoryOrderItemRepository : AbstractRepository<Int?, OrderItem, OrderItem.Builder>() {
    override fun getMapName() = OrderItem.MAP_NAME

    override fun getBuilder(m: OrderItem) = OrderItem.Builder(m.order, m.product)

    override fun nextId() = ORDER_ITEM_SEQUENCE.getAndIncrement()
}