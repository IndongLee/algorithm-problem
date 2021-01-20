package Programmers.Test

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.test.assertEquals

fun main(args: Array<String>) {
//    val input = readLine()
//    print("Hello Goorm! Your input is " + input)
    val test = T3Test()
    test.executeAllTest()
}

class TossDateTime private constructor(val standardDateTime: LocalDateTime) {
    companion object {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss")

        fun of(standardDateTime: String): TossDateTime {
            val parsedDateTime = LocalDateTime.parse(standardDateTime, formatter)
            return TossDateTime(parsedDateTime)
        }
    }

    fun compareWith(targetDateTimeString: String) {
        val targetDateTime = LocalDateTime.parse(targetDateTimeString, formatter)
        val dateTimeDiff = standardDateTime.compareTo(targetDateTime)
        println(dateTimeDiff)
    }
}

class T3Test {
    fun executeAllTest() {
        makeTossDateTimeTest()
        compareTimeTest()
    }

    fun makeTossDateTimeTest() {
        val tossDateTime = TossDateTime.of("2020-08-0112:00:00")
        assertEquals(LocalDateTime.of(2020, 8, 1, 12, 0, 0), tossDateTime.standardDateTime)
    }

    fun compareTimeTest() {
        val targetDateTime = "2020-08-0111:50:00"
        val tossDateTime = TossDateTime.of("2020-08-0112:00:00")
        val compareResult = tossDateTime.compareWith(targetDateTime)
//        assertEquals("10분 전", compareResult)
    }
}