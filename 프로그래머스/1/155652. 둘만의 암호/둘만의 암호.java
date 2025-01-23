import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        for (char c : s.toCharArray()) {
            int count = 0;
            while (count < index) {
                c++;
                if (c > 'z') {
                    c = 'a';
                }
                if (!skipSet.contains(c)) {
                    count++;
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }
}