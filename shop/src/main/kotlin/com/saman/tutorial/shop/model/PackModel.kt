package com.saman.tutorial.shop.model

import com.saman.tutorial.shop.domain.Pack

class PackModel(val count: Int, val pack: Pack) {
    override fun toString(): String = "$count * $pack"
}