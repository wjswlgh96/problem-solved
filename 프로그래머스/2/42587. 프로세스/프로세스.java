import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<data> queue = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new data(priorities[i], i));
            max = Math.max(max, priorities[i]);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            data d = queue.pollFirst();

            if (d.priority < max) {
                queue.offerLast(d);
            } else {
                count++;
                max = 0;

                for (data data : queue) {
                    max = Math.max(max, data.priority);
                }

                if (location == d.index) {
                    return count;
                }
            }
        }

        return count;
    }

    static class data {
        int priority;
        int index;

        public data(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }
}