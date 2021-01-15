package com.saman.tutorial.shop.domain

import com.saman.tutorial.shop.utils.convertAndJoinAsLine

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Order private constructor(builder: Builder) : AbstractModel<Int?>(builder) {

    companion object {
        const val MAP_NAME: String = "ORDER"

        fun creatEmpty() = Builder().build()
    }

    var items: MutableList<OrderItem> = builder.item

    override fun toString() = convertAndJoinAsLine(items)

    class Builder : AbstractBuilder<Int?, Order>() {

        var item: MutableList<OrderItem> = mutableListOf()
            private set

        @Suppress("unused")
        fun items(product: MutableList<OrderItem>): Builder {
            this.item = product
            return this
        }

        @Suppress("unused")
        fun item(product: OrderItem): Builder {
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