import kotlin.math.abs

class Day1 {
    enum class Direction {
        NORTH, SOUTH, EAST, WEST;

        fun turn(orientation: Char): Direction {
            return when (orientation) {
                'R' -> turnRight()
                'L' -> turnLeft()
                else ->{ throw Exception("Invalid orientation") }
            }
        }

        private fun turnLeft(): Direction {
            return when (this) {
                NORTH -> WEST
                SOUTH -> EAST
                EAST -> NORTH
                WEST -> SOUTH
            }
        }

        private fun turnRight(): Direction {
            return when (this) {
                NORTH -> EAST
                SOUTH -> WEST
                EAST -> SOUTH
                WEST -> NORTH
            }
        }
    }

    class Grid {
        private var direction = Direction.NORTH
        private var location = Pair(0, 0)
        private var visited = mutableListOf(Pair(0, 0))
        fun move(command: String){
            this.direction = direction.turn(command[0])
            val distance = command.substring(1).toInt()
            location = move(distance)
        }

        private fun move(distance: Int): Pair<Int, Int> {
            return when (this.direction) {
                Direction.NORTH -> moveNorth(distance)
                Direction.SOUTH -> moveSouth(distance)
                Direction.EAST -> moveEast(distance)
                Direction.WEST -> moveWest(distance)
            }
        }

        private fun moveNorth(distance: Int): Pair<Int, Int> {
            val startY = location.second
            val endY = location.second + distance

            for (i in startY+1..endY) {
                visited.add(Pair(location.first, i))
            }
            return Pair(location.first, endY)
        }

        private fun moveSouth(distance: Int): Pair<Int, Int> {
            val startY = location.second
            val endY = location.second - distance

            for (i in startY-1 downTo endY) {
                visited.add(Pair(location.first, i))
            }
            return Pair(location.first, endY)
        }

        private fun moveEast(distance: Int): Pair<Int, Int> {
            val startX = location.first
            val endX = location.first + distance

            for (i in startX+1..endX) {
                visited.add(Pair(i, location.second))
            }
            return Pair(endX, location.second)
        }

        private fun moveWest(distance: Int): Pair<Int, Int> {
            val startX = location.first
            val endX = location.first - distance

            for (i in startX-1 downTo endX) {
                visited.add(Pair(i, location.second))
            }
            return Pair(endX, location.second)
        }

        fun getBlocksAway(): Int {
            return getBlocksAway(location)
        }
        private fun getBlocksAway(pos: Pair<Int,Int>): Int {
            return abs(pos.first) + abs(pos.second)
        }

        fun getFirstVisitedTwice(): Int {
            val moreThanOnce = visited.groupingBy { it }.eachCount().filter { it.value > 1 }
            return getBlocksAway(moreThanOnce.keys.first())
        }
    }
}