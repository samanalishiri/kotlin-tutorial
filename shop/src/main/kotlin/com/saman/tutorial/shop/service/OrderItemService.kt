package com.saman.tutorial.shop.service

import com.saman.tutorial.shop.businesslogic.OrderItemHelper
import com.saman.tutorial.shop.businesslogic.OrderItemHelper.Companion.getMinimumPacks
import com.saman.tutorial.shop.domain.OrderItem
import com.saman.tutorial.shop.repository.InmemoryOrderItemRepository

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object OrderItemService :
    AbstractService<Int?, OrderItem, OrderItem.Builder, InmemoryOrderItemRepository>(InmemoryOrderItemRepository) {

    fun findMinimumPacks(item: OrderItem) = getMinimumPacks(item)
}