package Programmers.Test

import kotlin.math.min

private fun solution(snapshots: Array<Array<String>>, transactions: Array<Array<String>>): Array<Array<String>> {
    val accounts = hashMapOf<String, Int>()
    snapshots.forEach {
        accounts[it[0]] = it[1].toInt()
    }
    val checkId = BooleanArray(100_000)
    transactions.forEach {
        if (!checkId[it[0].toInt()]) {
            when (it[1]) {
                "SAVE" -> {
                    if (accounts.containsKey(it[2])) accounts[it[2]] = accounts[it[2]]!! + it[3].toInt()
                    else accounts[it[2]] = it[3].toInt()
                }
                "WITHDRAW" -> accounts[it[2]] = accounts[it[2]]!! - it[3].toInt()
            }
            checkId[it[0].toInt()] = true
        }
    }
    val answer = Array(accounts.size) { Array(2) { "" } }
    var idx = 0
    accounts.forEach { t, u ->
        answer[idx][0] = t
        answer[idx++][1] = u.toString()
    }
    println(answer.contentDeepToString())

    answer.sortWith(kotlin.Comparator { o1, o2 ->
        var value = 0
        for (i in 0 until min(o1[0].length, o2[0].length)) {
            if (o1[0][i] < o2[0][i]) {
                value = -1
                break
            }
            else if (o1[0][i] > o2[0][i]) {
                value = 1
                break
            }
        }
        when(value) {
            0 -> {
                when {
                    o1[0].length < o2[0].length -> -1
                    o1[0].length > o2[0].length -> 1
                    else -> 0
                }
            }
            else -> value
        }
    })

    println(answer.contentDeepToString())

    return answer
}