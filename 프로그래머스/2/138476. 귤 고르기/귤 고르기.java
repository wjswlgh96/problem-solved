import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < tangerine.length; i++) {
            int value = tangerine[i];
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        for (Integer i : map.keySet()) {
            list.add(map.get(i));
        }

        list.sort(null);
        Collections.reverse(list);

        int result = 0;
        for (Integer i : list) {
            if(k <= 0) break;

            k -= i;
            result++;
        }

        return result;
    }
}