package com.saman.tutorial.shop.model

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderItem : AbstractModel<Int?> {

    companion object {
        const val MAP_NAME: String = "ORDER_ITEM"
    }

    var qty: Int

    var product: Product

    private constructor(builder: Builder) : super(builder) {
        this.qty = builder.qty
        this.product = builder.product
    }

    override fun toString(): String {
        return String.format("%d @ %s", this.qty, this.product.name)
    }

    class Builder(val product: Product) : AbstractBuilder<Int?, OrderItem>() {
        var qty: Int = 0
            private set

        fun qty(qty: Int): Builder {
            this.qty = qty
            return this
        }

        override fun from(m: OrderItem): Builder {
            super.from(m)
            this.qty = m.qty
            return this
        }

        override fun build(): OrderItem {
            return OrderItem(this)
        }
    }
}