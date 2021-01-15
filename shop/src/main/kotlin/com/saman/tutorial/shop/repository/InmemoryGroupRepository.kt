package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.domain.GROUP_SEQUENCE
import com.saman.tutorial.shop.domain.Group

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object InmemoryGroupRepository : AbstractRepository<Int?, Group, Group.Builder>() {
    override fun getMapName() = Group.MAP_NAME

    override fun getBuilder(m: Group) = Group.Builder()

    override fun nextId() = GROUP_SEQUENCE.getAndIncrement()
}