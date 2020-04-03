package Programmers.L3

private class Solution {
    lateinit var root: IntArray
    lateinit var rank: IntArray

    fun find(x: Int): Int {
        if (x == root[x]) return x
        root[x] = find(root[x])
        return root[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX == rootY) return false

        if (rank[rootX] < rank[rootY]) root[rootX] = rootY
        else {
            root[rootY] = rootX
            if (rank[rootX] == rank[rootY]) rank[rootX]++
        }
        return true
    }

    fun solution(n: Int, computers: Array<IntArray>): Int {
        root = IntArray(n) { it }
        rank = IntArray(n)
        for (i in 0 until n) {
            for (j in i+1 until n) {
                if (computers[i][j] == 1) union(i, j)
            }
        }

        return root.filterIndexed { index, _ -> root[index] == index }.size
    }
}


fun main() {
    val s = Solution()
    println(s.solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))))
}