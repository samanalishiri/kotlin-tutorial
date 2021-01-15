package com.saman.tutorial.shop.storage

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object BeanFactory {

    private val map: MutableMap<String, Any> = mutableMapOf()

    fun register(name: String, bean: Any) {
        map[name] = bean
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getBean(name: String) = map[name] as T
}