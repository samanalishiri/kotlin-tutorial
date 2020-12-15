package com.saman.tutorial.shop.model

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Order : AbstractModel<Int?> {

    companion object {
        const val MAP_NAME: String = "ORDER"
    }

    var items: MutableList<OrderItem>

    private constructor(builder: Builder) : super(builder) {
        this.items = builder.item
    }

    class Builder : AbstractBuilder<Int?, Order>() {

        var item: MutableList<OrderItem> = mutableListOf()
            private set

        fun items(product: MutableList<OrderItem>): Builder {
            this.item = product
            return this
        }

        fun items(product: OrderItem): Builder {
            this.item.add(product)
            return this
        }

        override fun from(m: Order): Builder {
            super.from(m)
            this.item = m.items
            return this
        }

        override fun build(): Order = Order(this)

    }
}