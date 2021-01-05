package com.saman.tutorial.shop.service

import com.saman.tutorial.shop.domain.Order
import com.saman.tutorial.shop.model.OrderItemModel
import com.saman.tutorial.shop.model.OrderModel
import com.saman.tutorial.shop.repository.InmemoryOrderRepository

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object OrderService : AbstractService<Int?, Order, Order.Builder, InmemoryOrderRepository>(InmemoryOrderRepository) {

    fun calculate(order: Order): OrderModel {
        val orderDto = OrderModel()
        order.items.stream()
            .forEach { item ->
                orderDto.addItem(
                    OrderItemModel(item, OrderItemService.findMinimalNumberOfPacks(item))
                )
            }
        return orderDto
    }

}