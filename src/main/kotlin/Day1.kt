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
        private var visited = mutableListOf(Pair(0, 0))
        fun move(command: String){
            this.direction = direction.turn(command[0])
            val distance = command.substring(1).toInt()

            for (i in 1.. distance) {
                this.visited.add(move(visited.last()))
            }
        }

        private fun move(location: Pair<Int, Int>): Pair<Int, Int> {
            return when (this.direction) {
                Direction.NORTH -> Pair(location.first, location.second + 1)
                Direction.SOUTH -> Pair(location.first, location.second - 1)
                Direction.EAST -> Pair(location.first +1, location.second)
                Direction.WEST -> Pair(location.first -1, location.second)
            }
        }

        fun getBlocksAway(): Int {
            return getBlocksAway(visited.last())
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