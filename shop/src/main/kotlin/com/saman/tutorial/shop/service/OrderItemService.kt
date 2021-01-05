package com.saman.tutorial.shop.service

import com.saman.tutorial.shop.businesslogic.OrderItemHelper
import com.saman.tutorial.shop.domain.OrderItem
import com.saman.tutorial.shop.model.PackModel
import com.saman.tutorial.shop.repository.InmemoryOrderItemRepository

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object OrderItemService : AbstractService<Int?, OrderItem, OrderItem.Builder, InmemoryOrderItemRepository>
    (InmemoryOrderItemRepository) {

    private val helper: OrderItemHelper = OrderItemHelper()

    fun findMinimalNumberOfPacks(item: OrderItem): List<PackModel> = helper.findMinimalNumberOfPacks(item)

}