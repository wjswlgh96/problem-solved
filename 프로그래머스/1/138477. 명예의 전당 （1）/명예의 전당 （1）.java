import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int result[] = new int[score.length];
        queue.offer(score[0]);
        result[0] = score[0];
        for (int i = 1; i < score.length; i++) {
            if (i < k) {
                queue.offer(score[i]);
                result[i] = queue.peek();
            } else {
                int max = Math.max(score[i], queue.poll());
                queue.offer(max);
                result[i] = queue.peek();
            }
        }

        return result;
    }
}