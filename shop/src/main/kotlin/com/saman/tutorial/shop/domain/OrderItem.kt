package com.saman.tutorial.shop.domain

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class OrderItem private constructor(builder: Builder) : AbstractModel<Int?>(builder) {

    companion object {
        const val MAP_NAME: String = "ORDER_ITEM"
    }

    var qty: Int = builder.qty

    var product: Product = builder.product

    var order: Order = builder.order

    init {
        this.order.items.add(this)
    }

    override fun toString() = String.format("%d @ %s", this.qty, this.product.name)

    class Builder(val order: Order, val product: Product) : AbstractBuilder<Int?, OrderItem>() {
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

        override fun build() = OrderItem(this)
    }
}