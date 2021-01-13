package com.saman.tutorial.shop.domain

import com.saman.tutorial.shop.utils.CollectionUtils.Companion.mapTo
import com.saman.tutorial.shop.utils.CollectionUtils.Companion.joinString
import java.util.function.Function

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Order : AbstractModel<Int?> {

    companion object {
        fun creatEmpty(): Order {
            return Builder().build()
        }

        const val MAP_NAME: String = "ORDER"
    }

    var items: MutableList<OrderItem>

    private constructor(builder: Builder) : super(builder) {
        this.items = builder.item
    }

    override fun toString(): String {
        return joinString(mapTo(items, Function { it.toString() }))
    }

    class Builder : AbstractBuilder<Int?, Order>() {

        var item: MutableList<OrderItem> = mutableListOf()
            private set

        fun items(product: MutableList<OrderItem>): Builder {
            this.item = product
            return this
        }

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