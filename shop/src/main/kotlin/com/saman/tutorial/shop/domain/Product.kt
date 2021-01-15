package com.saman.tutorial.shop.domain

import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Product private constructor(builder: Builder) : AbstractModel<Int?>(builder) {

    companion object {
        const val MAP_NAME: String = "PRODUCT"

        @Suppress("unused")
        fun createEmpty() = Builder(Group.Builder().build()).build()
    }

    var name: String = builder.name

    var code: String = builder.code

    var price: BigDecimal = builder.price

    var group: Group = builder.group

    var packs: MutableList<Pack> = builder.packs

    var discount: MutableList<ProductDiscount> = builder.discount

    init {
        this.group.products.add(this)
    }

    override fun toString() = StringBuilder()
        .append(String.format("%1s ", name))
        .append(String.format("%1s ", code))
        .append(packs.joinToString(prefix = "[", postfix = "]"))
        .append(discount.joinToString(prefix = "[", postfix = "]"))
        .toString()

    class Builder(val group: Group) : AbstractBuilder<Int?, Product>() {

        var name: String = ""
            private set

        var code: String = ""
            private set

        var price: BigDecimal = BigDecimal.ZERO
            private set

        var packs: MutableList<Pack> = mutableListOf()

        var discount: MutableList<ProductDiscount> = mutableListOf()

        fun name(name: String): Builder {
            this.name = name
            return this
        }

        fun code(code: String): Builder {
            this.code = code
            return this
        }

        fun price(price: BigDecimal): Builder {
            this.price = price
            return this
        }

        @Suppress("unused")
        fun packs(packs: MutableList<Pack>): Builder {
            this.packs = packs
            return this
        }

        @Suppress("unused")
        fun packs(vararg pack: Pack): Builder {
            this.packs.addAll(pack)
            return this
        }

        @Suppress("unused")
        fun discount(vararg discount: ProductDiscount): Builder {
            this.discount.addAll(discount)
            return this
        }

        override fun from(m: Product): Builder {
            super.from(m)
            this.name = m.name
            this.code = m.code
            this.price = m.price
            this.packs.addAll(0, m.packs)
            this.discount.addAll(0, m.discount)
            return this
        }

        override fun build() = Product(this)
    }
}