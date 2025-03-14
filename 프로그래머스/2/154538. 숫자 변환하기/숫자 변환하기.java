import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{x, 0});

        Set<Integer> visited = new HashSet<>();
        visited.add(x);

        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int value = current[0];
            int steps = current[1];

            if (value == y) {
                return steps;
            }

            int[] nextValues = {value + n, value * 2, value * 3};
            for (int next : nextValues) {
                if (next <= y && !visited.contains(next)) {
                    visited.add(next);
                    queue.offer(new Integer[]{next, steps + 1});
                }
            }
        }

        return -1;
    }
}