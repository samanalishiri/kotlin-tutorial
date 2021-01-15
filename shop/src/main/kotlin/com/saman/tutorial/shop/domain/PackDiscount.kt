package com.saman.tutorial.shop.domain

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class PackDiscount private constructor(builder: Builder) : Discount<Int?>(builder) {

    companion object {
        const val MAP_NAME: String = "PACK_DISCOUNT"

        @Suppress("unused")
        fun zeroDiscount(product: Pack) = Builder(product, 0).build()
    }

    var pack: Pack = builder.pack

    init {
        this.pack.discount.add(this)
    }

    override fun toString(): String = String.format("%d % discount", this.percent)

    class Builder(product: Pack, percent: Int) : DiscountBuilder<Int?, PackDiscount>(percent) {

        var pack: Pack = product
            private set

        override fun from(m: PackDiscount): Builder {
            super.from(m)
            this.pack = m.pack
            return this
        }

        override fun build(): PackDiscount = PackDiscount(this)
    }

}