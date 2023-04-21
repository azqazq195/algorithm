package src.programmers.level2.모음사전

fun main() {
    val word1 = "AAAAE"
    val answer1 = 6
    val result1 = Solution().solution(word1)
    check(result1 == answer1) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: $result1\n" +
                "\t- 기댓값: $answer1\n"
    }

    val word2 = "AAAE"
    val answer2 = 10
    val result2 = Solution().solution(word2)
    check(result2 == answer2) {
        "\n\n테스트 케이스 2\n" +
                "\t- 실행 결과: $result2\n" +
                "\t- 기댓값: $answer2\n"
    }

    val word3 = "I"
    val answer3 = 1563
    val result3 = Solution().solution(word3)
    check(result3 == answer3) {
        "\n\n테스트 케이스 3\n" +
                "\t- 실행 결과: $result3\n" +
                "\t- 기댓값: $answer3\n"
    }

    val word4 = "EIO"
    val answer4 = 1189
    val result4 = Solution().solution(word4)
    check(result4 == answer4) {
        "\n\n테스트 케이스 4\n" +
                "\t- 실행 결과: $result4\n" +
                "\t- 기댓값: $answer4\n"
    }
}

class Solution {
    fun solution(word: String): Int {
        val char = arrayOf("", "A", "E", "I", "O", "U")
        dfs(char)
        list.sort()
        return list.indexOf(word) + 1
    }

    val list = mutableListOf<String>()
    fun dfs(array: Array<String>, depth: Int = 0, str: String = "") {
        if (depth == 5) {
            if (str.isNotBlank() && !list.contains(str)) {
                list.add(str)
            }
            return
        }

        for (char in array) {
            dfs(array, depth + 1, str + char)
        }
    }
}