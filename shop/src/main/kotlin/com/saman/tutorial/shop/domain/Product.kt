package com.saman.tutorial.shop.domain

import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Product : AbstractModel<Int?> {

    companion object {
        fun buildEmpty(): Product {
            return Builder(Group.Builder().build()).build()
        }

        const val MAP_NAME: String = "PRODUCT"
    }

    var name: String

    var code: String

    var price: BigDecimal

    var group: Group

    var packs: MutableList<Pack>

    private constructor(builder: Builder) : super(builder) {
        this.name = builder.name
        this.code = builder.code
        this.price = builder.price
        this.group = builder.group
        this.group.products.add(this)
        this.packs = builder.packs
    }

    override fun toString(): String {
        return StringBuilder()
            .append(String.format("%1s ", name))
            .append(String.format("%1s ", code))
            .append(packs.joinToString(prefix = "[", postfix = "]"))
            .toString();
    }

    class Builder(val group: Group) : AbstractBuilder<Int?, Product>() {

        var name: String = ""
            private set

        var code: String = ""
            private set

        var price: BigDecimal = BigDecimal.ZERO
            private set

        var packs: MutableList<Pack> = mutableListOf()

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

        fun packs(packs: MutableList<Pack>): Builder {
            this.packs = packs
            return this
        }

        fun packs(vararg pack: Pack): Builder {
            this.packs.addAll(pack)
            return this
        }

        override fun from(m: Product): Builder {
            super.from(m)
            this.name = m.name
            this.code = m.code
            this.price = m.price
            this.packs.addAll(0, m.packs)
            return this
        }

        override fun build() = Product(this)
    }
}