import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                String s = String.valueOf(keymap[i].charAt(j));

                if (map.containsKey(s)) {
                    if (map.get(s) > j) {
                        map.put(s, j + 1);
                    } else {
                        continue;
                    }
                } else {
                    map.put(s, j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                String s = String.valueOf(targets[i].charAt(j));
                if (map.containsKey(s)) {
                    answer[i] += map.get(s);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}