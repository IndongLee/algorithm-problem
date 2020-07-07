package Programmers.Test

import kotlin.collections.ArrayList

private fun solution(ip_addrs: Array<String>, langs: Array<String>, scores: IntArray): Int {
    var answer = ip_addrs.size
    val langsMap = hashMapOf("C" to 0, "C++" to 0, "C#" to 0, "Java" to 1, "JavaScript" to 2, "Python3" to 3)
    val ipMap = hashMapOf<String, ArrayList<IntArray>>()
    ip_addrs.forEachIndexed { index, ip ->
        if (!ipMap.containsKey(ip)) {
            ipMap[ip] = arrayListOf()
        }
        ipMap[ip]!!.add(intArrayOf(langsMap[langs[index]]!!, scores[index]))
    }

    ipMap.forEach { (_, info) ->
        when (info.size) {
            1 -> {}
            2 -> {
                if (info[0].contentEquals(info[1])) answer -= 2
            }
            3 -> {
                if (info.count { it[0] == info[0][0] } == 3) answer -= 3
            }
            else -> { answer -= info.size }
        }
    }
    return answer
}