package Programmers.Test

fun IntArray.swap(x: Int, y: Int) {
    val temp: Int = this[x]
    this[x] = this[y]
    this[y] = temp
}


fun IntArray.bubbleSort() {
    for (order in size downTo 0) {
        for (i in 1 until order) {
            if (this[i-1] > this[i]) {
                swap(i-1, i)
            }
        }
    }
}

fun IntArray.selectSort() {
    for (order in indices) {
        var minIndex = order
        for (i in order until size) {
            if (this[minIndex] > this[i]) {
                minIndex = i
            }
        }
        swap(order, minIndex)
    }
}

fun IntArray.insertSort() {
    for (order in 1 until size) {
        var i = order - 1
        val key = this[order]
        while (i >= 0 && this[i] > key) {
            this[i+1] = this[i--]
        }
        this[i+1] = key
    }
}

fun countingSort(array: IntArray, maxNum: Int): IntArray {
    val count = IntArray(maxNum + 1) { 0 }

    array.forEach {
        count[it]++
    }

    for (i in 0 until maxNum) {
        count[i+1] += count[i]
    }

    val result = IntArray(array.size) { -1 }
    array.forEach { number ->
        result[count[number]-- - 1] = number
    }
    return result
}

fun IntArray.mergeSort(start: Int, end: Int): IntArray {
    if (start + 1 == end) {
        return IntArray(1) { this[start] }
    }
    val mid = (start + end) / 2
    val left = mergeSort(start, mid)
    val right = mergeSort(mid, end)
    return merge(left, right)
}

fun merge(left: IntArray, right: IntArray): IntArray {
    var i = 0
    var j = 0
    val sizeL = left.size
    val sizeR = right.size
    var index = 0
    val sortedList = IntArray(sizeL + sizeR)
    while (i < sizeL && j < sizeR) {
        when {
            left[i] < right[j] -> sortedList[index++] = left[i++]
            else -> sortedList[index++] = right[j++]
        }
    }
    while (i < sizeL) sortedList[index++] = left[i++]
    while (j < sizeR) sortedList[index++] = right[j++]

    return sortedList
}

fun IntArray.quickSort(left: Int, right: Int) {
    if (left < right) {
        val pivot = partitionArray(left, right)
        quickSort(left, pivot - 1)
        quickSort(pivot + 1, right)
    }
}

fun IntArray.partitionArray(left: Int, right: Int): Int {
    val pivot = this[right]
    var i = left
    for (j in left until right) {
        if (this[j] <= pivot) {
            swap(i++, j)
        }
    }
    swap(i, right)
    return i
}


fun main() {
    for (i in 5 downTo 0) println(i)
}