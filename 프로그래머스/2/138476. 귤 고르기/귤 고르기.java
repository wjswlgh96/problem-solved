import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            int value = tangerine[i];
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> b - a);

        int result = 0;
        for (Integer value : list) {
            k -= value;
            result++;

            if(k <= 0) break;
        }

        return result;
    }
}