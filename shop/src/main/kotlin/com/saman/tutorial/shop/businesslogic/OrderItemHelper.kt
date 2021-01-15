package com.saman.tutorial.shop.businesslogic

import com.saman.tutorial.shop.domain.OrderItem
import com.saman.tutorial.shop.domain.Pack
import com.saman.tutorial.shop.domain.Pack.Companion.createUnitPack
import com.saman.tutorial.shop.model.PackModel
import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
fun getMinimumPacksOf(item: OrderItem) = getAnswer(getAllAnswers(item), createDefaultAnswer(item))

private fun getAnswer(answers: List<List<PackModel>>, default: List<PackModel>) =
    if (answers.isEmpty()) default
    else getBestAnswer(answers)

private fun getAllAnswers(item: OrderItem): List<List<PackModel>> {
    val packs: List<Pack> = item.product.packs.sortedByDescending { it.getWeight() }
    val answers: MutableList<List<PackModel>> = ArrayList()

    for (i in 1 until (1 shl packs.size)) {

        var qty = item.qty
        val answer: MutableList<PackModel> = ArrayList()

        for (j in packs.indices) {
            if (i and (1 shl j) > 0) {
                val weight = packs[j].getWeight()
                val count = if (qty >= weight) qty / weight else 0

                answer.add(PackModel(count, packs[j]))

                if (qty % weight == 0) answers.add(answer)
                qty %= weight
            }
        }
    }
    return answers
}

private fun getBestAnswer(a: List<List<PackModel>>) = a.sortedWith(compareBy(::totalCount, ::totalPrice)).first()

private fun createDefaultAnswer(item: OrderItem) = listOf(PackModel(item.qty, createUnitPack(item.product)))
