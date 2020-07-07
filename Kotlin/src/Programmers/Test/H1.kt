package Programmers.Test

private fun solution(purchase: Array<String>): IntArray {
    val monthMap = hashMapOf(1 to 31, 2 to 28, 3 to 31, 4 to 30, 5 to 31, 6 to 30, 7 to 31, 8 to 31, 9 to 30, 10 to 31, 11 to 30, 12 to 31)
    val startIndex = hashMapOf(1 to 0)
    for (i in 2..12) {
        startIndex[i] = startIndex[i-1]!! + monthMap[i-1]!!
    }
    val total = IntArray(365)
    purchase.forEach {
        val info = it.split(" ")
        val date = info[0].split("/")
        val month = date[1]
        val day = date[2]
        val money = info[1].toInt()
        val index = startIndex[month.toInt()]!! + day.toInt() - 1
        for (i in index until index+30) {
            if (i >= 365) break
            total[i] += money
        }
    }

    val answer = IntArray(5)
    total.forEach {
        when (it) {
            in 0 until 10_000 -> answer[0]++
            in 10_000 until 20_000 -> answer[1]++
            in 20_000 until 50_000 -> answer[2]++
            in 50_000 until 100_000 -> answer[3]++
            else -> answer[4]++
        }
    }
    return answer
}

fun main() {
    println(
        solution(
            arrayOf(
                "2019/01/01 5000",
                "2019/01/20 15000",
                "2019/02/09 90000"
            )
        ).contentToString())
}