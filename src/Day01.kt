fun main() {
    fun part1(input: List<String>): Int {
        return input.map { it.toInt() }.zipWithNext()
            .count { (prev, next) -> next > prev }
    }

    fun part2(input: List<String>): Int {
        return input.asSequence()
            .map { it.toInt() }
            .windowed(3)
            .map { it.sum() }
            .zipWithNext()
            .count { (prev, next) -> next > prev }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
