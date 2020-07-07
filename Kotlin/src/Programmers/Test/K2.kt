package Programmers.Test

import kotlin.math.abs
import kotlin.math.max

private fun maxHeight(wallPositions: Array<Int>, wallHeights: Array<Int>): Int {
    val size = wallPositions.size
    if (size == 1) return 0

    var maxValue = 0
    outer@for (i in 1 until size) {
        val dis = wallPositions[i] - wallPositions[i-1] - 1
        val diff = wallHeights[i] - wallHeights[i-1]
        when {
            dis == 0 -> continue@outer
            dis < abs(diff) -> {
                maxValue = if (diff >= 0) max(maxValue, wallHeights[i-1] + dis) else max(maxValue, wallHeights[i] + dis)
            }
            else -> {
                val curveLength: Int
                val curve: Int
                val curMax: Int
                if (diff < 0) {
                    curveLength = dis + diff
                    curve = if (curveLength % 2 == 1) (curveLength / 2) + 1 else curveLength / 2
                    curMax = wallHeights[i-1] + curve
                } else {
                    curveLength = dis - diff
                    curve = if (curveLength % 2 == 1) (curveLength / 2) + 1 else curveLength / 2
                    curMax = wallHeights[i-1] + diff + curve
                }
                maxValue = max(maxValue, curMax)
            }
        }
    }
    return maxValue
}

fun main() {
    println(
        maxHeight(
            arrayOf(4, 5, 6, 9, 10, 11, 12, 13, 14),
            arrayOf(20, 22, 11, 14, 14, 21, 19, 14, 23)
        )
    )
}