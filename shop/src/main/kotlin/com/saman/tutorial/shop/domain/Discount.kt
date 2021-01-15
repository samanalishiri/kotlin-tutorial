package com.saman.tutorial.shop.domain

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
abstract class Discount<I> protected constructor(builder: DiscountBuilder<*, *>) : AbstractModel<I>(builder) {

    var percent: Int = builder.percent

    override fun toString(): String = String.format("%d % discount", this.percent)

    abstract class DiscountBuilder<I, M : Discount<I>> protected constructor(var percent: Int) :
        AbstractBuilder<I, M>() {

        override fun from(m: M): DiscountBuilder<I, M> {
            super.from(m)
            this.percent = m.percent
            return this
        }
    }
}