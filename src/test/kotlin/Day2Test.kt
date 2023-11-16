import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2Test {

    @Test
    fun gridSetup() {
        val grid = Day2.Grid()
        assertEquals("5",grid.getKey())
    }

    @Test
    fun testSample() {
        val grid = Day2.Grid()
        assertEquals("1",grid.move("ULL"))
        assertEquals("9",grid.move("RRDDD"))
        assertEquals("8",grid.move("LURDL"))
        assertEquals("5",grid.move("UUUUD"))
    }

    @Test
    fun testBathroomCode() {
        val grid = Day2.Grid()
        val commands = arrayOf("ULL", "RRDDD","LURDL","UUUUD")
        assertEquals("1985",grid.getBathroomCode(commands))
    }

    @Test
    fun testPart1() {
        val grid = Day2.Grid()
        val commands = Util().readData("day2.txt").toTypedArray()
        assertEquals("53255",grid.getBathroomCode(commands))
    }

    @Test
    fun testSamplePart2() {
        val grid = Day2.Grid(Day2.StarKeypad, 0, 2)
        assertEquals("5",grid.move("ULL"))
        assertEquals("D",grid.move("RRDDD"))
        assertEquals("B",grid.move("LURDL"))
        assertEquals("3",grid.move("UUUUD"))
    }

    @Test
    fun testPart2() {
        val grid = Day2.Grid(Day2.StarKeypad, 0, 2)
        val commands = Util().readData("day2.txt").toTypedArray()
        assertEquals("7423A",grid.getBathroomCode(commands))
    }
}