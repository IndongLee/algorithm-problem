package Programmers.Test

import kotlin.math.floor
import kotlin.math.round
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val input = readLine()

    val test = T1Test()
    test.executeAllTest()

    val colorCode = ColorCode.from(input!!)
    println(colorCode.calculateARGB())
}

class ColorCode(
    val color: String,
    val alpha: Int
) {
    companion object {
        fun from(input: String): ColorCode {
            return input.split(",").let { colorCode ->
                ColorCode(colorCode[0], colorCode[1].toInt())
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        other as ColorCode
        return this.color == other.color && this.alpha == other.alpha
    }

    fun convertAlphaToHex(alpha: Int): String {
        val decimalValue = floor(alpha * 2.55).toInt()
        val hexValue = Integer.toHexString(decimalValue).toUpperCase()
        return if (hexValue.length == 1) "0${hexValue}" else hexValue
    }

    fun calculateARGB(): String {
        return "#${convertAlphaToHex(alpha)}${color.substring(1)}"
    }
}

class T1Test {
    fun executeAllTest() {
        inputFormatTest()
        makeDecimaltoHex()
        makeARGB()
    }

    fun inputFormatTest() {
        val input = "#FFFFFF,0"
        val colorCode = ColorCode.from(input)
        assertEquals(ColorCode("#FFFFFF", 0), colorCode)
    }

    fun makeDecimaltoHex() {
        val input = "#FFFFFF,50"
        val colorCode = ColorCode.from(input)
        val hexValue50 = colorCode.convertAlphaToHex(50)
        val hexValue0 = colorCode.convertAlphaToHex(0)
        assertEquals("7F", hexValue50)
        assertEquals("00", hexValue0)
    }

    fun makeARGB() {
        val input = "#FFFFFF,100"
        val colorCode = ColorCode.from(input)
        val ARGB = colorCode.calculateARGB()
        assertEquals("#FFFFFFFF", ARGB)
    }
}