package LeetCode.medium

class BrowserHistory(homepage: String) {
    private val history = arrayListOf(homepage)
    private var currentPage = 0
    private var lastIndex = 0

    fun visit(url: String) {
        val removeCount = lastIndex - currentPage
        for (i in 1..removeCount) {
            history.removeAt(lastIndex--)
        }
        history.add(url)
        currentPage = ++lastIndex
        println(history)
    }

    fun back(steps: Int): String {
        currentPage = if (currentPage - steps < 0) 0 else currentPage - steps
        return history[currentPage]
    }

    fun forward(steps: Int): String {
        currentPage = if (currentPage + steps > lastIndex) lastIndex else currentPage + steps
        return history[currentPage]
    }

}
