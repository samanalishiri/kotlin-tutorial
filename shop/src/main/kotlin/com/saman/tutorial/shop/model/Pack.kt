package com.saman.tutorial.shop.model

import com.saman.tutorial.shop.utils.CurrencyUtils.Companion.convertToMoneyFormat
import java.math.BigDecimal

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Pack : AbstractModel<Int?>, Knapsack {

    companion object {
        const val MAP_NAME: String = "PACK"
    }

    var qty: Int

    var price: BigDecimal

    var product: Product?

    private constructor(builder: Builder) : super(builder) {
        this.qty = builder.qty
        this.price = builder.price
        this.product = builder.product
    }

    override fun getWeight(): Int {
        return qty
    }

    override fun getValue(): BigDecimal {
        return price
    }

    override fun toString(): String {
        return String.format("%d @ %s", this.qty, convertToMoneyFormat(this.price))
    }


    class Builder() : AbstractBuilder<Int?, Pack>() {
        var qty: Int = 0
            private set
        var price: BigDecimal = BigDecimal.ZERO
            private set

        var product: Product? = null
            private set

        fun qty(qty: Int): Builder {
            this.qty = qty
            return this
        }

        fun price(price: BigDecimal): Builder {
            this.price = price
            return this
        }

        fun goods(product: Product): Builder {
            this.product = product
            return this
        }

        override fun from(m: Pack): Builder {
            super.from(m)
            this.qty = m.qty
            this.price = m.price
            return this
        }

        override fun build(): Pack {
            return Pack(this)
        }
    }
}