package com.saman.tutorial.kotlin.collection

class NumberArray {

    companion object {
        fun arrayOfInts(size: Int = 10, vararg input: Int): Array<Int?> {
            val elements: Array<Int?> = arrayOfNulls(size)

            input?.let { (0 until input.size).forEach { index -> elements[index] = input[index] } }

            return elements
        }

        fun arrayOfInts(size: Int = 10, input: Array<Int?>): Array<Int?> {
            val elements: Array<Int?> = arrayOfNulls(size)

            input?.let { (0 until input.size).forEach { index -> elements[index] = input[index] } }

            return elements
        }
    }

    private var initSize: Int = 10

    private var index: Int = -1

    private var numbers: Array<Int?> = arrayOfNulls(initSize)


    fun getSize(): Int {
        return numbers.size
    }

    fun lastIndex(): Int {
        return index
    }

    fun add(number: Int) {
        if (lastIndex() + 1 >= numbers.size)
            increaseSizeOfArray()

        index++
        numbers[index] = number
    }

    fun set(index: Int, number: Int) {
        if (index < 0 || index > lastIndex())
            return

        numbers[index] = number
    }

    fun getAll(): Array<Int?> {
        return numbers;
    }

    fun get(index: Int): Int? {
        return numbers[index];
    }

    private fun increaseSizeOfArray() {
        numbers = arrayOfInts(getSize() + initSize, getAll());
    }

}
