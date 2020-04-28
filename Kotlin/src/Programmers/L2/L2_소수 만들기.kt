package Programmers.L2

private fun solution(nums: IntArray): Int {
    val len = nums.size
    val size = nums.sum() + 1
    var answer = 0
    val prime = makePrimeArray(size)

    for (i in 0 until len) {
        for (j in i + 1 until len) {
            for (k in j + 1 until len) {
                val sumNumber = nums[i] + nums[j] + nums[k]
                if (prime[sumNumber]) answer++
            }
        }
    }

    return answer
}

fun makePrimeArray(size: Int): BooleanArray {
    val prime = BooleanArray( size ) { true }
    for (i in 2 until size) {
        if (prime[i]) {
            for (j in i * 2 until size step i) {
                prime[j] = false
            }
        }
    }
    return prime
}

fun main() {

}