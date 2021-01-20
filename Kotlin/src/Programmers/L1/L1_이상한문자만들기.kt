package Programmers.L1

import kotlin.test.assertEquals

private fun solution(s: String): String {
    val converter = Converter()
    return converter.convert(s)
}

private class Converter {
    fun convert(string: String): String {
        val separatedString = string.split(" ")
        val convertedStrings = convertStrings(separatedString)

        return convertedStrings.joinToString(" ")
    }

    fun convertStrings(strings: List<String>): List<String> {
        return strings.map { word ->
            convertWordForIndex(word)
        }
    }

    fun convertWordForIndex(word: String): String {
        return word.foldIndexed(StringBuilder()) { index, acc, char ->
            val newAlphabet = convertCharForIndex(char, index)

            acc.append(newAlphabet)
        }.toString()
    }

    fun convertCharForIndex(char: Char, index: Int): String {
        return when (index % 2) {
            0 -> char.toString().toUpperCase()
            else -> char.toString().toLowerCase()
        }
    }
}

fun main() {
    val tester = ConverterTester()
    tester.mainTest()
    val convertedString = solution("try Hello World")
    println(convertedString)
}

private class ConverterTester {
    val converter = Converter()

    fun mainTest() {
        splitTest()
        convertCharForIndexTest()
        convertWordForIndexTest()
        convertStringsTest()
        joinToStringTest()
    }

    fun splitTest() {
        val s = "Hello World"
        val expected = listOf("Hello", "World")

        val separatedString = s.split(" ")

        assertEquals(expected, separatedString)
    }

    fun convertCharForIndexTest() {
        val char = 'c'
        val expected = "C"

        val index = 0

        val convertedWord = converter.convertCharForIndex(char, index)

        assertEquals(expected, convertedWord)
    }

    fun convertWordForIndexTest() {
        val word = "Hello"
        val expected = "HeLlO"

        val convertedWord = converter.convertWordForIndex(word)

        assertEquals(expected, convertedWord)
    }

    fun convertStringsTest() {
        val strings = listOf("Hello", "World")
        val expected = listOf("HeLlO", "WoRlD")

        val convertedStrings = converter.convertStrings(strings)

        assertEquals(expected, convertedStrings)
    }

    fun joinToStringTest() {
        val strings = listOf("HeLlO", "WoRlD")
        val expected = "HeLlO WoRlD"

        val combinedString = strings.joinToString(" ")

        assertEquals(expected, combinedString)
    }
}