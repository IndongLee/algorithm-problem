package Programmers.Test

private fun countBalancingElements(arr: Array<Int>): Int {
    var oddSum = 0
    var evenSum = 0
    arr.forEachIndexed { index, num ->
        if (index % 2 == 1) oddSum += num
        else evenSum += num
    }

    var prev = 0
    return arr.foldIndexed(0, { index, total, num ->
        val isOdd = index % 2 == 1
        when (isOdd) {
            true -> evenSum += num - prev
            false -> oddSum += num - prev
        }
        prev = num
        if (evenSum == oddSum) total + 1 else total
    })
}

fun main() {
    println(countBalancingElements(arrayOf(2, 2, 2)))
}