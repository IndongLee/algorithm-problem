package Programmers.L3

private fun solution(genres: Array<String>, plays: IntArray): IntArray {
    val answer = arrayListOf<Int>()
    val genreMap = hashMapOf<String, ArrayList<IntArray>>()
    genres.forEachIndexed { index, s ->
        if (genreMap.containsKey(s)) genreMap[s]!!.add(intArrayOf(plays[index], index))
        else genreMap[s] = arrayListOf(intArrayOf(plays[index], index))
    }
    genreMap
        .toList()
        .sortedByDescending { (_, value) -> value.sumBy { it[0] } }
        .toMap()
        .forEach { (_, value) ->
        answer += value.sortedWith(
            kotlin.Comparator{ o1, o2 ->
                when {
                    o1[0] > o2[0] -> -1
                    o1[0] < o2[0] -> 1
                    o1[1] < o2[1] -> -1
                    o1[1] > o2[1] -> 1
                    else -> 0
                }
            }
        ).map { it[1] }.take(2)}
    println(answer)

    return answer.toIntArray()
}

//fun solution(genres: Array<String>, plays: IntArray): IntArray {
//    return genres.indices.groupBy { genres[it] }
//        .toList()
//        .sortedByDescending { it.second.sumBy { plays[it] } }
//        .map { it.second.sortedByDescending { plays[it] }.take(2) }
//        .flatten()
//        .toIntArray()
//}

fun main() {
    println(
        solution(
            arrayOf("classic", "pop", "classic", "classic", "pop", "rock"),
            intArrayOf(500, 600, 150, 800, 2500, 100)
        )
    )
}