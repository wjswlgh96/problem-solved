import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> mbti = new HashMap<>();
        mbti.put('R', 0);
        mbti.put('T', 0);
        mbti.put('C', 0);
        mbti.put('F', 0);
        mbti.put('J', 0);
        mbti.put('M', 0);
        mbti.put('A', 0);
        mbti.put('N', 0);

        int[] score = {3, 2, 1, 0, 1, 2, 3};

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            char front =  survey[i].charAt(0);
            char end = survey[i].charAt(1);

            if (choice > 4) {
                mbti.put(end, mbti.get(end) + score[choice - 1]);
            } else {
                mbti.put(front, mbti.get(front) + score[choice - 1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(mbti.get('R') >= mbti.get('T') ? "R" : "T");
        sb.append(mbti.get('C') >= mbti.get('F') ? "C" : "F");
        sb.append(mbti.get('J') >= mbti.get('M') ? "J" : "M");
        sb.append(mbti.get('A') >= mbti.get('N') ? "A" : "N");

        return sb.toString();
    }
}