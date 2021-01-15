package com.saman.tutorial.shop.storage

import java.util.ServiceLoader.load

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
const val STORAGE_BEAN: String = "storage"

fun loadStorage() = BeanFactory.register(STORAGE_BEAN, load(Storage::class.java).first())