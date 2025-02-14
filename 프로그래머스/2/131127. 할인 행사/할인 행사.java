import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> originMap = new HashMap<>();
        Map<String, Integer> calcMap;
        for (int i = 0; i < want.length; i++) {
            originMap.put(want[i], number[i]);
        }

        calcMap = new HashMap<>(originMap);
        int count = 0;
        for (int i = 0; i <= discount.length - 10; i++) {

            for (int j = i; j < i + 10; j++) {
                String key = discount[j];
                if (calcMap.isEmpty()) {
                    break;
                }
                if (!calcMap.containsKey(key)) {
                    continue;
                }

                calcMap.put(key, calcMap.get(key) - 1);

                if (calcMap.get(key) == 0) {
                    calcMap.remove(key);
                }
            }
            
            count = calcMap.isEmpty() ? count + 1 : count;
            calcMap = new HashMap<>(originMap);
        }

        return count;
    }
}