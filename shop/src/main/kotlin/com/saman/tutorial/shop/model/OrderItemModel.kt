package com.saman.tutorial.shop.model

import com.saman.tutorial.shop.businesslogic.totalPrice
import com.saman.tutorial.shop.domain.OrderItem
import com.saman.tutorial.shop.utils.convertAndJoinAsIndentedLine
import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderItemModel(val item: OrderItem, val packs: List<PackModel>) {

    val sum: BigDecimal = totalPrice(packs)

    override fun toString() = "${this.item.qty}  ${this.item.product.code}  $sum" + convertAndJoinAsIndentedLine(packs)
}