import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int completeTime = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            queue.offer(completeTime);
        }

        while (!queue.isEmpty()) {
            int count = 1;
            int current = queue.poll();

            while(queue.size() > 0 && queue.peek() <= current) {
                queue.poll();
                count++;
            }

            result.add(count);
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}