package com.saman.tutorial.shop.domain

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
abstract class AbstractModel<I> protected constructor(builder: AbstractBuilder<*, *>) : Identity<I> {

    @Suppress("UNCHECKED_CAST")
    var identity: I? = builder.id as I

    var version: Int = builder.version

    override fun getId() = this.identity

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
            this.id = m.identity
            this.version = m.version
            return this
        }

        abstract fun build(): M
    }
}