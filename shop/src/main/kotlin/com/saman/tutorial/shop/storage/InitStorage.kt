package com.saman.tutorial.shop.storage

import com.saman.tutorial.shop.domain.*
import com.saman.tutorial.shop.storage.StorageProvider.STORAGE_BEAN

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class InitStorage {

    init {
        StorageProvider.loadStorage()
        val storage: Storage = BeanFactory.getBean(STORAGE_BEAN)
        storage.create(Group.MAP_NAME)
        storage.create(Product.MAP_NAME)
        storage.create(Pack.MAP_NAME)
        storage.create(OrderItem.MAP_NAME)
        storage.create(Order.MAP_NAME)
        storage.create(ProductDiscount.MAP_NAME)
        storage.create(PackDiscount.MAP_NAME)
    }
}