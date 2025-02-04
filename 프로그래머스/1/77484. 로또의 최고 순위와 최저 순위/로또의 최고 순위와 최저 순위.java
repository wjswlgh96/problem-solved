import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] ranks = {6, 6, 5, 4, 3, 2, 1};
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int zeroCount = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
            }
        }

        int rightCount = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                continue;
            }

            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    rightCount++;
                }
            }
        }

        return new int[]{ranks[rightCount + zeroCount], ranks[rightCount] };
    }
}