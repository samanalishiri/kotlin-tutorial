package com.saman.tutorial.shop.model

import com.saman.tutorial.shop.domain.Pack

class PackModel {

    val count: Int

    val pack: Pack

    constructor(count: Int, pack: Pack) {
        this.count = count
        this.pack = pack
    }

    override fun toString(): String = "$count * $pack"

}