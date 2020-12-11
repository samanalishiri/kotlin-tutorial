package com.saman.tutorial.shop.model

import java.math.BigDecimal
import java.text.NumberFormat

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Pack : AbstractModel<Int?>, Knapsack {

    companion object {
        const val MAP_NAME: String = "PACK"
    }

    var qty: Int

    var price: BigDecimal

    var goods: Goods

    private constructor(builder: Builder) : super(builder) {
        this.qty = builder.qty
        this.price = builder.price
        this.goods = builder.goods
    }

    override fun getWeight(): Int {
        return qty
    }

    override fun getValue(): BigDecimal {
        return price
    }

    override fun toString(): String {
        return String.format("%d @ %s", this.qty, NumberFormat.getCurrencyInstance().format(this.price))
    }

    class Builder(val goods: Goods) : AbstractBuilder<Int?, Pack>() {
        var qty: Int = 0
            private set
        var price: BigDecimal = BigDecimal.ZERO
            private set

        fun qty(qty: Int): Builder {
            this.qty = qty
            return this
        }

        fun price(price: BigDecimal): Builder {
            this.price = price
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