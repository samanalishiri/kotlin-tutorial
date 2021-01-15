package com.saman.tutorial.shop.domain

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class ProductDiscount : Discount<Int?> {

    companion object {
        fun zeroDiscount(product: Product) = Builder(product, 0).build()

        const val MAP_NAME: String = "PRODUCT_DISCOUNT"
    }

    var product: Product

    private constructor(builder: Builder) : super(builder as DiscountBuilder<Int?, Discount<Int?>>) {
        this.product = builder.product
        this.product.discount.add(this)
    }

    override fun toString(): String = String.format("%d % discount", this.percent)

    class Builder : DiscountBuilder<Int?, ProductDiscount> {

        var product: Product
            private set

        constructor(product: Product, percent: Int) : super(percent) {
            this.product = product
        }

        override fun from(m: ProductDiscount): Builder {
            super.from(m)
            this.product = m.product
            return this
        }

        override fun build(): ProductDiscount = ProductDiscount(this)
    }

}