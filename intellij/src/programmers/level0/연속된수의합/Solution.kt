package src.programmers.level0.연속된수의합

fun main(args: Array<String>) {
    val num = 3
    val total = 12
    println(Solution().solution(num, total).contentToString())
}

class Solution {
    fun solution(num: Int, total: Int): IntArray =
        (total / num - (num - 1) / 2).let { t ->
            IntArray(num) { index -> index + t }
        }
}