package Programmers.L2

private fun solution(clothes: Array<Array<String>>): Int {
    val clothesMap = HashMap<String, ArrayList<String>>()
    var answer = 0
    clothes.forEach { if (!clothesMap.containsKey(it[1])) clothesMap[it[1]] = arrayListOf(it[0]) else clothesMap[it[1]]!!.add(it[0]) }
    clothesMap.forEach { t, u -> answer *= u.size + 1 }
    return --answer

}

//fun solution(clothes: Array<Array<String>>): Int {
//    return clothes.groupBy { it[1] }.values.fold(1) { acc, v -> acc * (v.size + 1) }  - 1
//}

fun main() {
    println(
        solution(
            arrayOf(
                arrayOf("yellow_hat", "headgear"),
                arrayOf("blue_sunglasses", "eyewear"),
                arrayOf("green_turban", "headgear")
            )
        )
    )
}