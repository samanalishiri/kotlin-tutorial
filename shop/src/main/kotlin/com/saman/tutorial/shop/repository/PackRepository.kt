package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.model.KeySequences
import com.saman.tutorial.shop.model.Pack

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object PackRepository : AbstractRepository<Int?, Pack, Pack.Builder>() {
    override fun getMapName(): String {
        return Pack.MAP_NAME
    }

    override fun getBuilder(pack: Pack): Pack.Builder {
        return Pack.Builder(pack.product)
    }

    override fun nextId(): Int {
        return KeySequences.PACK_SEQUENCE.getAndIncrement()
    }
}