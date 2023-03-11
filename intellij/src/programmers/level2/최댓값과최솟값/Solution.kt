package src.programmers.level2.최댓값과최솟값

fun main(args: Array<String>) {
    val s = "1 2 3 4"
    println(Solution().solution(s))
}

class Solution {
    fun solution(s: String): String {
        val array = s.split(" ").map { it.toInt() }.toIntArray()
        return "${array.minOrNull()} ${array.maxOrNull()}"
    }
}