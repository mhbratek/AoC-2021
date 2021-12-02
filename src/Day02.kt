fun main() {
    fun part1(input: List<String>): Int {
        return input.map { it.split(" ") }
            .map { it[0] to it[1].toInt() }
            .fold(0 to 0) { (depth, horizontal), (move, unit) ->
                when (move) {
                    "forward" -> depth to horizontal + unit
                    "up" -> depth - unit to horizontal
                    else -> depth + unit to horizontal
                }
            }
            .let { (depth, horizontal) -> depth * horizontal }
    }

    fun part2(input: List<String>): Int {
        return input.map { it.split(" ") }
            .map { it[0] to it[1].toInt() }
            .fold(Triple(0,0,0)) { (depth, horizontal, aim), (move, unit) ->
                when (move) {
                    "forward" -> Triple(depth + (aim * unit), horizontal + unit, aim)
                    "up" -> Triple(depth, horizontal, aim - unit)
                    else -> Triple(depth, horizontal, aim + unit)
                }
            }
            .let { (depth, horizontal) -> depth * horizontal }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
//    check(part1(testInput) == 150)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}


data class Pos(var horizontal: Int = 0, var depth: Int = 0, var aim: Int = 0) {
    fun move1(cmd: String, x: Int) {
        when (cmd) {
            "forward" -> horizontal += x
            "up" -> depth -= x
            "down" -> depth += x
        }
    }

    fun move2(cmd: String, x: Int) {
        when (cmd) {
            "forward" -> {
                horizontal += x; depth += aim * x
            }
            "up" -> aim -= x
            "down" -> aim += x
        }
    }

    fun calc() = horizontal * depth
}
