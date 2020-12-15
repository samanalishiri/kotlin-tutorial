package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.model.KeySequences
import com.saman.tutorial.shop.model.Order
import com.saman.tutorial.shop.model.Product
import java.util.stream.Collectors

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object OrderRepository : AbstractRepository<Int?, Order, Order.Builder>() {
    override fun getMapName(): String {
        return Order.MAP_NAME
    }

    override fun getBuilder(order: Order): Order.Builder {
        return Order.Builder()
    }

    override fun nextId(): Int {
        return KeySequences.ORDER_SEQUENCE.getAndIncrement()
    }

    override fun completeRelationReferences(model: Order) {
        model.items = model.items.stream()
                .map {
                    OrderItemRepository.save(it)
                    it
                }
                .collect(Collectors.toList())
    }
}