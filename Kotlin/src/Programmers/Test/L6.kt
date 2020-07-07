package Programmers.Test

private fun solution(directory: Array<String>, command: Array<String>): Array<String> {
    val listDir = directory.sorted().toMutableList()
    for (i in command.indices) {
        if (command[i][0] == 'm') {
            listDir.add(command[i].split(" ")[1])
        }
    }
    return listDir.toTypedArray()
}