import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            result[i] = map.containsKey(c) ? i - map.get(c) : -1;
            map.put(c, i);
        }

        return result;
    }
}