package com.saman.tutorial.shop.utils

import java.util.function.Function
import java.util.stream.Collectors

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */

inline fun <T, reified R> mapTo(list: List<T>, m: Function<T, R>): MutableList<R> = list.stream()
    .map(m)
    .collect(Collectors.toList())

fun join(a: List<String>, s: String = ",", pr: String = "", po: String = "") = a.joinToString(s, pr, po)

fun joinAsLine(a: List<String>) = join(a, "\n", "\n")

fun <T> convertAndJoinAsLine(a: List<T>) = joinAsLine(mapTo(a, Function { it.toString() }))

fun <T> convertAndJoinAsIndentedLine(a: List<T>) = join(mapTo(a, Function { it.toString() }), "\n\t", "\n\t")