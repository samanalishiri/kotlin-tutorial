package com.saman.tutorial.kotlin.pattern

data class Order(val table: Int, val menus: List<String>, val additional: String?, val status: String, val version: Int) {

    companion object {
        const val ORDERING_STATUS = "ORDERING"
        const val IS_HANDED_OVER_STATUS = "IS_HANDED_OVER_STATUS"
    }

    private constructor(builder: Builder) :
            this(builder.table, builder.menus, builder.additional, builder.status, builder.version)

    fun isHandedOver(): Order {
        val order = this

        return Builder(table = order.table)
                .apply { this.status = IS_HANDED_OVER_STATUS }
                .apply { this.menus = order.menus }
                .apply { this.version = order.version.plus(1) }
                .additional(order.additional)
                .build()
    }

    class Builder(val table: Int) {
        var menus: List<String> = mutableListOf()
            internal set

        var additional: String? = null
            private set

        var status: String = ORDERING_STATUS
            internal set

        var version: Int = 1
            internal set

        fun menu(menu: String) = apply { this.menus = this.menus.plus(menu) }

        fun additional(additional: String?) = apply { this.additional = additional }

        fun build() = Order(this)
    }

}