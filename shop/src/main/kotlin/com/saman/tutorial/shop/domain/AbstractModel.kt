package com.saman.tutorial.shop.domain

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
abstract class AbstractModel<I> : Identity<I> {

    override var id: I?

    var version: Int

    protected constructor(builder: Any) {
        builder as AbstractBuilder<I, AbstractModel<I>>
        this.id = builder.id
        this.version = builder.version
    }

    abstract class AbstractBuilder<I, M : AbstractModel<I>> {

        var id: I? = null
            private set

        var version: Int = 0
            private set

        fun id(id: I): AbstractBuilder<I, M> {
            this.id = id
            return this
        }

        fun version(): AbstractBuilder<I, M> {
            this.version++
            return this
        }

        open fun from(m: M): AbstractBuilder<I, M> {
            this.id = m.id
            this.version = m.version
            return this
        }

        abstract fun build(): M
    }
}