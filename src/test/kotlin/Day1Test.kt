import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1Test {

    @Test
    fun firstSample() {
        val grid = Day1.Grid()
        grid.move("R2")
        grid.move("L3")
        assertEquals(5,grid.getBlocksAway())
    }

    @Test
    fun secondSample() {
        val grid = Day1.Grid()
        grid.move("R2")
        grid.move("R2")
        grid.move("R2")
        assertEquals(2,grid.getBlocksAway())
    }

    @Test
    fun thirdSample() {
        val grid = Day1.Grid()

        grid.move("R5")
        grid.move("L5")
        grid.move("R5")
        grid.move("R3")

        assertEquals(12,grid.getBlocksAway())
    }

    @Test
    fun part1() {
        val commands = Util().readData("day1.txt")[0].split(", ")
        val grid = Day1.Grid()
        commands.forEach { grid.move(it) }
        assertEquals(287, grid.getBlocksAway())
    }

    @Test
    fun part2Sample(){
        val commands = "R8, R4, R4, R8".split(", ")
        val grid = Day1.Grid()
        commands.forEach { grid.move(it) }
        assertEquals(4, grid.getFirstVisitedTwice())
    }

    @Test
    fun part2() {
        val commands = Util().readData("day1.txt")[0].split(", ")
        val grid = Day1.Grid()
        commands.forEach { grid.move(it) }
        assertEquals(133, grid.getFirstVisitedTwice())
    }
}