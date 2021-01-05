package com.saman.tutorial.shop.businesslogic

import com.saman.tutorial.shop.model.PackModel
import java.math.BigDecimal
import java.util.stream.Collectors

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class PackHelper {

    companion object {
        fun calculateTotalPrice(packs: List<PackModel>): BigDecimal {
            var total = BigDecimal.valueOf(0)
            val collect = packs.stream()
                .map { item: PackModel -> item.pack.price.multiply(BigDecimal.valueOf(item.count.toLong())) }
                .collect(Collectors.toList())

            for (n in collect) {
                total = total.add(n)
            }

            return total
        }

        fun totalCount(packs: List<PackModel>): Int {
            return packs.stream().mapToInt(PackModel::count).sum()
        }
    }
}