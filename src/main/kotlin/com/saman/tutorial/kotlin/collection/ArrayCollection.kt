package com.saman.tutorial.kotlin.collection

class ArrayCollection {

    private var numbers: Array<Int> = Array(size = 1) { 0 }
    private var index: Int = -1

    fun getSize(): Int {
        return index + 1
    }

    fun add(element: Int) {
        if (getSize() >= numbers.size)
            increaseSizeOfArray()

        index++
        numbers[index] = element
    }

    fun getAll(): Array<Int> {
        return numbers;
    }

    fun get(index: Int): Int {
        return numbers[index];
    }

    private fun increaseSizeOfArray() {
        var temp: Array<Int> = Array(size = getSize() + 1) { 0 }
        System.arraycopy(numbers, 0, temp, 0, getSize())
        numbers = temp;
    }

}
