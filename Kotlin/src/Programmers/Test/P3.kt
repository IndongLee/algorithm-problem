package Programmers.Test

private fun solution(command: String, buttons: Array<String>, scores: IntArray): Int {
    val len = command.length
    val useSkillArray = Array(len) { hashMapOf(1 to 1) }

    for (i in buttons.indices) {
        val button = buttons[i]
        val buttonLength = button.length
        for (j in 0..len - buttonLength) {
            if (button == command.substring(j, j+buttonLength)) {
                useSkillArray[j][buttonLength] = scores[i]
            }
        }
    }

    var result = 0
    fun findMaxScore(index: Int, score: Int) {
        if (index == len) {
            if (result < score) {
                result = score
            }
            return
        }

        for (scoreInfo in useSkillArray[index]) {
            val nextScore = score + scoreInfo.value
            findMaxScore(index + scoreInfo.key, nextScore)
        }
    }
    findMaxScore(0, 0)

    return result
}



fun main() {

}