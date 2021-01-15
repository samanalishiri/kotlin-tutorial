package com.saman.tutorial.shop.domain

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Discount : AbstractModel<Int?> {

    companion object {
        fun zeroDiscount(product: Product) = Builder(product).percent(0).build()

        const val MAP_NAME: String = "PACK"
    }

    var percent: Int

    var product: Product

    private constructor(builder: Builder) : super(builder) {
        this.percent = builder.percent
        this.product = builder.product
        this.product.discount.add(this)
    }

    override fun toString(): String = String.format("%d % discount", this.percent)

    class Builder : AbstractBuilder<Int?, Discount> {

        var percent: Int = 0
            private set

        var product: Product
            private set

        constructor(product: Product) {
            this.product = product
        }

        fun percent(qty: Int): Builder {
            this.percent = qty
            return this
        }

        override fun from(m: Discount): Builder {
            super.from(m)
            this.percent = m.percent
            return this
        }

        override fun build(): Discount = Discount(this)
    }

}