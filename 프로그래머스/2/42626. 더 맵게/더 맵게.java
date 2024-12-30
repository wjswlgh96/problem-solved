import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        int count = 0;
        while (!queue.isEmpty() && queue.peek() < K) {
            if (queue.peek() < K && queue.size() <= 1) {
                count = -1;
                break;
            } else if (queue.peek() < K & queue.size() >= 2) {
                int first = queue.poll();
                int second = queue.poll();

                int scov = first + (second * 2);
                queue.offer(scov);

                count++;
            }
        }
        
        return count;
    }
}