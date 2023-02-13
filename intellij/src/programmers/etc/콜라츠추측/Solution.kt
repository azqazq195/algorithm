package src.programmers.etc.콜라츠추측

fun main(args: Array<String>) {
    val n = 16
    println(Solution().solution(n))
}

class Solution {
    fun solution(num: Int): Int = collatzAlgorithm(num.toLong(), 0)

    private tailrec fun collatzAlgorithm(n: Long, c: Int): Int =
        when {
            c > 500 -> -1
            n == 1L -> c
            else -> collatzAlgorithm(if (n % 2 == 0L) n / 2 else (n * 3) + 1, c + 1)
        }
}