import java.util.*;

class Solution {
    public int solution(String word) {
        Map<String, Integer> map = Map.of(
                "A", 0,
                "E", 1,
                "I", 2,
                "O", 3,
                "U", 4
        );
        int[] arr = {781, 156, 31, 6, 1};

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            String w = String.valueOf(word.charAt(i));
            count += map.get(w) * arr[i];
        }

        return count + word.length();
    }
}