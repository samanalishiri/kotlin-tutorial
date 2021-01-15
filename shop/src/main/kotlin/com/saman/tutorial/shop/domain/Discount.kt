package com.saman.tutorial.shop.domain

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
abstract class Discount<I> : AbstractModel<I> {

    var percent: Int

    protected constructor(builder: DiscountBuilder<I, Discount<I>>) : super(builder) {
        this.percent = builder.percent
    }

    override fun toString(): String = String.format("%d % discount", this.percent)

    abstract class DiscountBuilder<I, M: Discount<I>> : AbstractBuilder<I, M> {

        var percent: Int = 0
            private set

        protected constructor(percent: Int) {
            this.percent = percent
        }

        override fun from(m: M): DiscountBuilder<I, M> {
            super.from(m)
            this.percent = m.percent
            return this
        }
    }
}