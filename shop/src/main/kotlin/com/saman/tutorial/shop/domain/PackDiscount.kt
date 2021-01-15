package com.saman.tutorial.shop.domain

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class PackDiscount : Discount<Int?> {

    companion object {
        fun zeroDiscount(product: Pack) = Builder(product, 0).build()

        const val MAP_NAME: String = "PACK_DISCOUNT"
    }

    var pack: Pack

    private constructor(builder: Builder) : super(builder as DiscountBuilder<Int?, Discount<Int?>>) {
        this.pack = builder.pack
        this.pack.discount.add(this)
    }

    override fun toString(): String = String.format("%d % discount", this.percent)

    class Builder : DiscountBuilder<Int?, PackDiscount> {

        var pack: Pack
            private set

        constructor(product: Pack, percent: Int): super(percent) {
            this.pack = product
        }

        override fun from(m: PackDiscount): Builder {
            super.from(m)
            this.pack = m.pack
            return this
        }

        override fun build(): PackDiscount = PackDiscount(this)
    }

}