package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.model.Group
import com.saman.tutorial.shop.model.KeySequences

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object GroupRepository : AbstractRepository<Int?, Group, Group.Builder>() {
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