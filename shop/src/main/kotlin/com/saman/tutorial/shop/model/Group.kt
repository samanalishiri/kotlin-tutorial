package com.saman.tutorial.shop.model

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Group : AbstractModel<Int?> {

    companion object {
        const val MAP_NAME: String = "GROUP"
    }

    val name: String

    val products: MutableList<Product>

    private constructor(builder: Builder) : super(builder) {
        this.name = builder.name
        this.products = builder.products
    }

    override fun toString(): String {
        return this.name
    }

    class Builder : AbstractBuilder<Int?, Group>() {

        var name: String = ""
            private set

        var products: MutableList<Product> = mutableListOf()
            private set

        fun name(name: String): Builder {
            this.name = name
            return this
        }

        fun products(product: MutableList<Product>): Builder {
            this.products = product
            return this
        }

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