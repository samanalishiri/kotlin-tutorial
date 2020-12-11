package com.saman.tutorial.shop.model

import java.math.BigDecimal
import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Goods : AbstractModel<Int?> {

    companion object {
        const val MAP_NAME: String = "GOODS"
    }

    var name: String

    var code: String

    var price: BigDecimal

    var group: Group? = null

    var packs: Array<Pack?>

    private constructor(builder: Builder) : super(builder) {
        this.name = builder.name
        this.code = builder.code
        this.price = builder.price
        this.group = builder.group
        this.packs = builder.packs
    }

    override fun toString(): String {
        return StringBuilder()
                .append(String.format("$%1s ", name))
                .append(String.format("$%1s ", code))
                .append(packs.contentToString())
                .toString();
    }

    class Builder : AbstractBuilder<Int?, Goods>() {

        var name: String = ""
            private set

        var code: String = ""
            private set

        var price: BigDecimal = BigDecimal.ZERO
            private set

        var group: Group? = null
            private set

        var packs: Array<Pack?> = arrayOfNulls(0)

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

        fun group(group: Group): Builder {
            this.group = group
            return this
        }

        fun packs(packs: Array<Pack?>): Builder {
            this.packs = packs
            return this
        }

        override fun from(m: Goods): Builder {
            super.from(m)
            this.name = m.name
            this.code = m.code
            this.price = m.price
            this.group = m.group
            return this
        }

        override fun build() = Goods(this)
    }
}