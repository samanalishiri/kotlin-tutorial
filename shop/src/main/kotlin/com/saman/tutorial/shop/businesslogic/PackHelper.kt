package com.saman.tutorial.shop.businesslogic

import com.saman.tutorial.shop.model.PackModel
import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
fun totalPrice(packs: List<PackModel>) = packs.stream()
    .map { item: PackModel -> item.pack.price.multiply(BigDecimal.valueOf(item.count.toLong())) }
    .reduce { t: BigDecimal, u: BigDecimal -> t.add(u) }
    .get()

fun totalCount(packs: List<PackModel>) = packs.stream().mapToInt(PackModel::count).sum()