package com.saman.tutorial.shop.domain

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class ProductDiscount private constructor(builder: Builder) : Discount<Int?>(builder) {

    companion object {
        const val MAP_NAME: String = "PRODUCT_DISCOUNT"

        @Suppress("unused")
        fun zeroDiscount(product: Product) = Builder(product, 0).build()
    }

    var product: Product = builder.product

    init {
        this.product.discount.add(this)
    }

    override fun toString() = String.format("%d % discount", this.percent)

    class Builder(product: Product, percent: Int) : DiscountBuilder<Int?, ProductDiscount>(percent) {

        var product: Product = product
            private set

        override fun from(m: ProductDiscount): Builder {
            super.from(m)
            this.product = m.product
            return this
        }

        override fun build(): ProductDiscount = ProductDiscount(this)
    }
}