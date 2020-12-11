package com.saman.tutorial.shop.storage

import java.util.*

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object StorageProvider {

    const val STORAGE_BEAN: String = "storage"

    fun loadStorage() {
        BeanFactory.register(STORAGE_BEAN, ServiceLoader.load(Storage::class.java).first())
    }
}