package com.saman.tutorial.shop.storage

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class BeanFactory private constructor() {

    companion object {
        private val map: MutableMap<String, Any> = mutableMapOf()

        fun register(name: String, bean: Any) {
            map[name] = bean
        }

        fun <T> getBean(name: String): T {
            return map[name] as T
        }
    }

}