package com.saman.tutorial.shop.businesslogic

import com.saman.tutorial.shop.businesslogic.PackHelper.Companion.calculateTotalPrice
import com.saman.tutorial.shop.businesslogic.PackHelper.Companion.totalCount
import com.saman.tutorial.shop.domain.OrderItem
import com.saman.tutorial.shop.domain.Pack
import com.saman.tutorial.shop.model.PackModel
import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderItemHelper {
    /**
     * @param item
     * @return
     */
    fun findMinimalNumberOfPacks(item: OrderItem): List<PackModel> {
        val answers = findAllAnswers(item)
        return if (answers.isEmpty()) {
            createDefaultAnswer(item)
        } else findBestAnswer(answers)
    }

    /**
     * @param item
     * @return
     */
    private fun findAllAnswers(item: OrderItem): List<List<PackModel>> {
        var packs: List<Pack> = item.product.packs
        packs = packs.sortedByDescending { it.getWeight() }

        val answers: MutableList<List<PackModel>> = ArrayList()
        for (i in 1 until (1 shl packs.size)) {
            var qty = item.qty
            val answer: MutableList<PackModel> = ArrayList()
            for (j in packs.indices) {
                if (i and (1 shl j) > 0) {
                    val weight = packs[j].getWeight()
                    val count = if (qty >= weight) qty / weight else 0
                    answer.add(PackModel(count, packs[j]))
                    if (qty % weight == 0)
                        answers.add(answer)

                    qty %= weight
                }
            }
        }
        return answers
    }

    /**
     * @param answers
     * @return
     */
    private fun findBestAnswer(answers: List<List<PackModel>>): List<PackModel> {
        var result = answers[0]
        for (answer in answers) {
            if (totalCount(answer) < totalCount(result)
                && BigDecimalHelper.of(calculateTotalPrice(answer)).isLessThanOrEquals(calculateTotalPrice(result))
            ) {
                result = answer
            }
        }
        return result
    }

    /**
     * @param item
     * @return
     */
    private fun createDefaultAnswer(item: OrderItem): List<PackModel> {
        return Arrays.asList(
            PackModel(
                item.qty, Pack.Builder(item.product)
                    .qty(1)
                    .price(item.product.price)
                    .build()
            )
        )
    }
}