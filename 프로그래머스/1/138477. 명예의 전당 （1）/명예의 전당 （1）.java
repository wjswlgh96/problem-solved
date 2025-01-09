import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int result[] = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            queue.offer(score[i]);
            if (queue.size() > k) {
                queue.poll();
            }

            result[i] = queue.peek();
        }

        return result;
    }
}