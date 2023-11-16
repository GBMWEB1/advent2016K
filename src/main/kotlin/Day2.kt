

class Day2 {
    companion object{
        val DefaultKeypad = arrayOf(
            arrayOf("1", "2", "3"),
            arrayOf("4", "5", "6"),
            arrayOf("7", "8", "9")
        )

        val StarKeypad = arrayOf(
            arrayOf("", "", "1", "", ""),
            arrayOf("", "2", "3", "4", ""),
            arrayOf("5", "6", "7", "8", "9"),
            arrayOf("", "A", "B", "C", ""),
            arrayOf("", "", "D", "", ""),
        )
    }

    class Grid(private val keypad : Array<Array<String>> = DefaultKeypad, private var x: Int =1, private var y: Int =1)
    {
        fun getKey(): String {
            return keypad[y][x]
        }

        fun move(command: String): String {
            command.forEach { move(it) }
            return getKey()
        }

        private fun move (direction: Char) {
            var nextX = x
            var nextY = y
            when (direction) {
                'U' -> if (y > 0) nextY--
                'D' -> if (y < keypad.size-1) nextY++
                'L' -> if (x > 0) nextX--
                'R' -> if (x < keypad[0].size-1) nextX++
            }
            if (keypad[nextY][nextX] != "") {
                x = nextX
                y = nextY
            }
        }

        fun getBathroomCode(commands: Array<String>): String {
            return commands.joinToString(separator = "") { move(it) }
        }
    }

}