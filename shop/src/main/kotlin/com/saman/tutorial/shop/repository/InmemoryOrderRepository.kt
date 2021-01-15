package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.domain.ORDER_SEQUENCE
import com.saman.tutorial.shop.domain.Order
import java.util.stream.Collectors

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object InmemoryOrderRepository : AbstractRepository<Int?, Order, Order.Builder>() {
    override fun getMapName() = Order.MAP_NAME

    override fun getBuilder(m: Order) = Order.Builder()

    override fun nextId() = ORDER_SEQUENCE.getAndIncrement()

    override fun beforeSave(model: Order) {
        model.items = model.items.stream()
            .map {
                InmemoryOrderItemRepository.save(it)
                it
            }
            .collect(Collectors.toList())
    }
}