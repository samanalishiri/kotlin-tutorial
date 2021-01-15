package com.saman.tutorial.shop.domain

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Group private constructor(builder: Builder) : AbstractModel<Int?>(builder) {

    companion object {
        const val MAP_NAME: String = "GROUP"
    }

    val name: String = builder.name

    val products: MutableList<Product> = builder.products

    override fun toString() = this.name

    class Builder : AbstractBuilder<Int?, Group>() {

        var name: String = ""
            private set

        var products: MutableList<Product> = mutableListOf()
            private set

        fun name(name: String): Builder {
            this.name = name
            return this
        }

        @Suppress("unused")
        fun products(product: MutableList<Product>): Builder {
            this.products = product
            return this
        }

        @Suppress("unused")
        fun products(product: Product): Builder {
            this.products.add(product)
            return this
        }

        override fun from(m: Group): Builder {
            super.from(m)
            this.name = m.name
            return this
        }

        override fun build(): Group = Group(this)
    }
}