package src.leetcode.topinterview150.two_sum2;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] numbers = new int[]{12, 13, 23, 28, 43, 44, 59, 60, 61, 68, 70, 86, 88, 92, 124, 125, 136, 168, 173, 173, 180, 199, 212, 221, 227, 230, 277, 282, 306, 314, 316, 321, 325, 328, 336, 337, 363, 365, 368, 370, 370, 371, 375, 384, 387, 394, 400, 404, 414, 422, 422, 427, 430, 435, 457, 493, 506, 527, 531, 538, 541, 546, 568, 583, 585, 587, 650, 652, 677, 691, 730, 737, 740, 751, 755, 764, 778, 783, 785, 789, 794, 803, 809, 815, 847, 858, 863, 863, 874, 887, 896, 916, 920, 926, 927, 930, 933, 957, 981, 997};
        int target = 542;
        int[] result = new Solution().twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSum1(int[] numbers, int target) {
        int front = 0;
        int back = numbers.length - 1;

        while (true) {
            int sum = numbers[front] + numbers[back];
            if (sum == target) break;

            if (sum < target) front++;
            else back--;
        }

        return new int[]{front + 1, back + 1};
    }
}