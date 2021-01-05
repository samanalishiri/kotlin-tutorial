package com.saman.tutorial.shop.businesslogic

import com.saman.tutorial.shop.businesslogic.PackHelper.Companion.calculateTotalPrice
import com.saman.tutorial.shop.businesslogic.PackHelper.Companion.totalCount
import com.saman.tutorial.shop.domain.OrderItem
import com.saman.tutorial.shop.domain.Pack
import com.saman.tutorial.shop.domain.Pack.Companion.createUnitPack
import com.saman.tutorial.shop.model.PackModel
import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderItemHelper {

    companion object {

        fun getMinimumPacks(item: OrderItem) =
            findBestAnswerOrGetDefault(findAllAnswers(item), createDefaultAnswer(item))

        private fun findBestAnswerOrGetDefault(
            answers: List<List<PackModel>>,
            defaultAnswer: List<PackModel>
        ) = if (answers.isEmpty()) defaultAnswer else findBestAnswer(answers)

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

        private fun findBestAnswer(answers: List<List<PackModel>>) =
            answers.sortedWith(compareBy(::totalCount, ::calculateTotalPrice)).first()

        private fun createDefaultAnswer(item: OrderItem) = listOf(PackModel(item.qty, createUnitPack(item.product)))
    }
}
