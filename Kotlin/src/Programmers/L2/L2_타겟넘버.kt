package Programmers.L2

private fun solution(numbers: IntArray, target: Int): Int {
    val size = numbers.size
    var answer = 0

    tailrec fun dfs(num: Int, index: Int): Int {
        if (index == size) {
            return when(num) {
                target -> 1
                else -> 0
            }
        }
        return dfs(num + numbers[index], index+1) + dfs(num - numbers[index], index+1)
    }

    return dfs(0, 0)
}

//private fun solution(numbers: IntArray, target: Int): Int {
//    return numbers.fold(listOf(0)) { list, i ->
//        list.run {
//            map { it + i } + map { it - i }
//        }
//    }.count { it == target }
//}

fun main() {

}