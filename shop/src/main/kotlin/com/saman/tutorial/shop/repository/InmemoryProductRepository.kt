package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.domain.PRODUCT_SEQUENCE
import com.saman.tutorial.shop.domain.Product
import java.util.stream.Collectors

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object InmemoryProductRepository : AbstractRepository<Int?, Product, Product.Builder>() {


    override fun getMapName() = Product.MAP_NAME

    override fun getBuilder(m: Product) = Product.Builder(m.group)

    override fun nextId() = PRODUCT_SEQUENCE.getAndIncrement()

    override fun beforeSave(model: Product) {
        model.packs = model.packs.stream()
            .map {
                InmemoryPackRepository.save(it)
                it
            }
            .collect(Collectors.toList())
    }
}