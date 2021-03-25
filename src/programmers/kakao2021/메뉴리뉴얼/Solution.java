package src.programmers.kakao2021.메뉴리뉴얼;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        System.out.println(solution(orders, course));
    }

    static List<Map<String, Integer>> FoodMaps = new ArrayList<>();
    static int[] MaxCnt = new int[11];

    static void comb(char[] str, int pos, StringBuilder candi) {
        if (pos >= str.length) {
            int len = candi.length();
            if (len >= 2) {
                int cnt = FoodMaps.get(len).getOrDefault(candi.toString(), 0) + 1;
                FoodMaps.get(len).put(candi.toString(), cnt);
                MaxCnt[len] = Math.max(MaxCnt[len], cnt);
            }
            return;
        }

        comb(str, pos + 1, candi.append(str[pos]));
        candi.setLength(candi.length() - 1);
        comb(str, pos + 1, candi);
    }

    public static String[] solution(String[] orders, int[] course) {
        // 코스는 2이상 10 이하인 자연수
        for (int i = 0; i <= 10; ++i)
            FoodMaps.add(new HashMap<>());

        for (String str : orders) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            comb(arr, 0, new StringBuilder());
        }

        List<String> list = new ArrayList<>();
        for (int len : course) {
            for (Map.Entry<String, Integer> entry : FoodMaps.get(len).entrySet()) {
                if(entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]) {
                    list.add(entry.getKey());
                }
            }
        }
        Collections.sort(list);

        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }
        return answer;
    }
}
