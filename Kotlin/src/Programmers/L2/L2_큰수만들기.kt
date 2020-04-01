package Programmers.L2

private fun solution(number: String, k: Int): String {
    var count = k
    val stack = arrayListOf<Int>()
    var last = -1
    number.map(Character::getNumericValue).forEach {
        while (stack.isNotEmpty() && stack[last] < it && count > 0) {
            stack.removeAt(last--)
            count--
        }
        stack.add(it)
        last++
    }

    while (count > 0) {
        stack.removeAt(last--)
        count--
    }

    return stack.fold(StringBuilder()) { total, next -> total.append(next.toString()) }.toString()
}

fun main() {
    println(solution("4177252841", 5))
}