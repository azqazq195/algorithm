package src.programmers.level1.추억_점수;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] name1 = new String[]{"may", "kein", "kain", "radi"};
        int[] yearning1 = new int[]{5, 10, 1, 3};
        String[][] photo1 = new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        int[] answer1 = new int[]{19, 15, 6};
        int[] result1 = new Solution().solution(name1, yearning1, photo1);
        PRINT_RESULT(1, result1, answer1);

        String[] name2 = new String[]{"kali", "mari", "don"};
        int[] yearning2 = new int[]{11, 1, 55};
        String[][] photo2 = new String[][]{{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};
        int[] answer2 = new int[]{67, 0, 55};
        int[] result2 = new Solution().solution(name2, yearning2, photo2);
        PRINT_RESULT(2, result2, answer2);

        String[] name3 = new String[]{"may", "kein", "kain", "radi"};
        int[] yearning3 = new int[]{5, 10, 1, 3};
        String[][] photo3 = new String[][]{{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};
        int[] answer3 = new int[]{5, 15, 0};
        int[] result3 = new Solution().solution(name3, yearning3, photo3);
        PRINT_RESULT(3, result3, answer3);
    }

    public static void PRINT_RESULT(int index, int[] result, int[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int count = 0;
            for (int k = 0; k < photo[i].length; k++) {
                count += map.getOrDefault(photo[i][k], 0);
            }

            answer[i] = count;
        }

        return answer;
    }
}