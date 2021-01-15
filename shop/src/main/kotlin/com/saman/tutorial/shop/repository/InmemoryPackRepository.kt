package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.domain.PACK_SEQUENCE
import com.saman.tutorial.shop.domain.Pack

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object InmemoryPackRepository : AbstractRepository<Int?, Pack, Pack.Builder>() {
    override fun getMapName() = Pack.MAP_NAME

    override fun getBuilder(m: Pack) = Pack.Builder(m.product)

    override fun nextId() = PACK_SEQUENCE.getAndIncrement()
}