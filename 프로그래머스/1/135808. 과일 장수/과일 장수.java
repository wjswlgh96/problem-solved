import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);

        int result = 0;
        for (int i = score.length; i >= m; i -= m) {
            result += score[i - m] * m;
        }

        return result;
    }
}