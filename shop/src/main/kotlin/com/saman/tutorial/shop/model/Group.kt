package com.saman.tutorial.shop.model

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class Group : AbstractModel<Int?> {

    companion object {
        const val MAP_NAME: String = "GROUP"
    }

    val name: String

    val goods: MutableList<Product>

    private constructor(builder: Builder) : super(builder) {
        this.name = builder.name
        this.goods = builder.goods
    }

    override fun toString(): String {
        return this.name
    }

    class Builder : AbstractBuilder<Int?, Group>() {

        var name: String = ""
            private set

        var goods: MutableList<Product> = mutableListOf()
            private set

        fun name(name: String): Builder {
            this.name = name
            return this
        }

        fun goods(goods: MutableList<Product>): Builder {
            this.goods = goods
            return this
        }

        fun goods(product: Product): Builder {
            this.goods.add(product)
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