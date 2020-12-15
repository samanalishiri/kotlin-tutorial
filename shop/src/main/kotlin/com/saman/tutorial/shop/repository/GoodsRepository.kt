package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.model.Goods
import com.saman.tutorial.shop.model.KeySequences
import java.util.stream.Collectors

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object GoodsRepository : AbstractRepository<Int?, Goods, Goods.Builder>() {


    override fun getMapName(): String {
        return Goods.MAP_NAME
    }

    override fun getBuilder(): Goods.Builder {
        return Goods.Builder()
    }

    override fun nextId(): Int {
        return KeySequences.GOODS_SEQUENCE.getAndIncrement()
    }

    override fun completeRelationReferences(model: Goods) {
        model.packs = model.packs.stream()
                .map {
                    it!!.goods = model
                    PackRepository.save(it)
                    it
                }
                .collect(Collectors.toList())

        model.group.goods.add(model)
    }
}