package com.saman.tutorial.shop.storage

import com.saman.tutorial.shop.model.Goods
import com.saman.tutorial.shop.model.Group
import com.saman.tutorial.shop.model.Pack
import com.saman.tutorial.shop.storage.StorageProvider.STORAGE_BEAN

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class InitStorage {

    init {
        StorageProvider.loadStorage()
        val storage: Storage = BeanFactory.getBean(STORAGE_BEAN)
        storage.create(Group.MAP_NAME)
        storage.create(Goods.MAP_NAME)
        storage.create(Pack.MAP_NAME)
    }
}