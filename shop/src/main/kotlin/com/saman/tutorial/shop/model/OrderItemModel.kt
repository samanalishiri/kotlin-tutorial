package com.saman.tutorial.shop.model

import com.saman.tutorial.shop.businesslogic.PackHelper.Companion.calculateTotalPrice
import com.saman.tutorial.shop.domain.OrderItem
import com.saman.tutorial.shop.utils.CollectionUtils.Companion.joinString
import com.saman.tutorial.shop.utils.CollectionUtils.Companion.mapTo
import java.math.BigDecimal
import java.util.function.Function

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderItemModel(item: OrderItem, val packs: List<PackModel>) {

    val qty: Int = item.qty

    val code: String = item.product.code

    val sum: BigDecimal = calculateTotalPrice(packs)

    override fun toString(): String =
        "$qty  $code  $sum" + joinString(mapTo(packs, Function { it.toString() }), "\n\t", "\n\t")
}