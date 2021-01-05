package com.saman.tutorial.shop.utils

import java.util.function.Function
import java.util.stream.Collectors

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
class CollectionUtils private constructor() {

    companion object {
        fun <T, R> mapTo(list: List<T>, mapper: Function<T, R>): List<R> = list.stream()
            .map(mapper)
            .collect(Collectors.toList())

        inline fun <T, reified R> mapToArray(list: List<T>, mapper: Function<T, R>): Array<R> = mapTo(list, mapper).toTypedArray()

        fun multiLine(list: List<String>): String {
            return list.joinToString(separator = "\n")
        }

    }
}