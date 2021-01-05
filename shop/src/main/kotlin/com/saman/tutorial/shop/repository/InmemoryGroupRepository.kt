package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.domain.Group
import com.saman.tutorial.shop.domain.KeySequences

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object InmemoryGroupRepository : AbstractRepository<Int?, Group, Group.Builder>() {
    override fun getMapName(): String {
        return Group.MAP_NAME
    }

    override fun getBuilder(group: Group): Group.Builder {
        return Group.Builder()
    }

    override fun nextId(): Int {
        return KeySequences.GROUP_SEQUENCE.getAndIncrement()
    }
}