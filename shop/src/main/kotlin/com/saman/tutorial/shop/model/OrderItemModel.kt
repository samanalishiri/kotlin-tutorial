package com.saman.tutorial.shop.model

import com.saman.tutorial.shop.businesslogic.PackHelper
import com.saman.tutorial.shop.domain.OrderItem
import com.saman.tutorial.shop.utils.CollectionUtils
import com.saman.tutorial.shop.utils.CollectionUtils.Companion.mapTo
import com.saman.tutorial.shop.utils.CollectionUtils.Companion.multiLine
import java.math.BigDecimal
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderItemModel(item: OrderItem, packs: List<PackModel>) {

    val qty: Int = item.qty

    val code: String = item.product.code

    val packs: List<PackModel> = packs

    val sum: BigDecimal = PackHelper.calculateTotalPrice(packs)

    override fun toString(): String = qty.toString() + " " + code + " " + sum +
            packs.stream().map { it.toString() }.collect(Collectors.toList()).joinToString(separator = "\n\t", prefix = "\n\t")

}