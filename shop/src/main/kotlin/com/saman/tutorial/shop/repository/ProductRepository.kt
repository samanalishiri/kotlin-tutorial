package com.saman.tutorial.shop.repository

import com.saman.tutorial.shop.model.Product
import com.saman.tutorial.shop.model.KeySequences
import java.util.stream.Collectors

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
object ProductRepository : AbstractRepository<Int?, Product, Product.Builder>() {


    override fun getMapName(): String {
        return Product.MAP_NAME
    }

    override fun getBuilder(product: Product): Product.Builder {
        return Product.Builder(product.group)
    }

    override fun nextId(): Int {
        return KeySequences.PRODUCT_SEQUENCE.getAndIncrement()
    }

    override fun completeRelationReferences(model: Product) {
        model.packs = model.packs.stream()
                .map {
                    PackRepository.save(it)
                    it
                }
                .collect(Collectors.toList())
    }
}