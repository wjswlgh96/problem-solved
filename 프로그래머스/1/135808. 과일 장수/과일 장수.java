import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
        }
        list.sort((a, b) -> b - a);

        int result = 0;
        for (int i = 0; i < list.size(); i = i + m) {
            if ((i + m - 1) >= list.size()) {
                break;
            }

            int min = Math.min(list.get(i), list.get(i + m - 1));
            result += (min * m);
        }

        return result;
    }
}