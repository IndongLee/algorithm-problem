package LeetCode.easy

private fun shuffle(nums: IntArray, n: Int): IntArray {
    val newArray = IntArray(n * 2)
    for (i in 0 until n) {
        newArray[i*2] = nums[i]
        newArray[(i*2)+1] = nums[n+i]
    }
    return newArray
}