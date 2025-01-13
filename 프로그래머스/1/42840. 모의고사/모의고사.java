import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        int fCount = 0;
        int sCount = 0;
        int tCount = 0;
        for (int i = 0; i < answers.length; i++) {
            if (first[i % 5] == answers[i]) {
                fCount++;
            }
            if (second[i % 8] == answers[i]) {
                sCount++;
            }
            if (third[i % 10] == answers[i]) {
                tCount++;
            }
        }

        int max = Math.max(fCount, sCount);
        max = Math.max(max, tCount);
        List<Integer> list = new ArrayList<>();
        if (fCount == max) {
            list.add(1);
        }
        if (sCount == max) {
            list.add(2);
        }
        if (tCount == max) {
            list.add(3);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}