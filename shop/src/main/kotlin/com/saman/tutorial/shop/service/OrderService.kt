package com.saman.tutorial.shop.service

import com.saman.tutorial.shop.domain.Order
import com.saman.tutorial.shop.model.OrderItemModel
import com.saman.tutorial.shop.model.OrderModel
import com.saman.tutorial.shop.repository.InmemoryOrderRepository
import com.saman.tutorial.shop.utils.CollectionUtils.Companion.mapToArray
import java.util.function.Function

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object OrderService : AbstractService<Int?, Order, Order.Builder, InmemoryOrderRepository>(InmemoryOrderRepository) {

    fun calculate(order: Order): OrderModel = OrderModel().addItem(
        *mapToArray(
            order.items,
            Function { OrderItemModel(it, OrderItemService.findMinimalNumberOfPacks(it)) })
    )
}