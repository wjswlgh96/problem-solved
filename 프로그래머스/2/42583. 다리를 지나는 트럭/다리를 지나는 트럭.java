import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        int time = 0;
        int bridgeWeight = 0;

        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            time++;
            bridgeWeight -= queue.poll();

            if (index < truck_weights.length) {
                if (bridgeWeight + truck_weights[index] <= weight) {
                    queue.offer(truck_weights[index]);
                    bridgeWeight += truck_weights[index];
                    index++;
                } else {
                    queue.offer(0);
                }
            }
        }

        return time;
    }
}