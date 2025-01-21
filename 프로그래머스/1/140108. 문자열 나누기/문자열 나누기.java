import java.util.*;

class Solution {
    public int solution(String s) {
        int result = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int otherCount = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek().equals(c)) {
                    stack.push(c);
                } else {
                    otherCount++;
                }
            }

            if (stack.size() == otherCount) {
                stack.clear();
                otherCount = 0;
                result++;
            }
        }

        if (!stack.isEmpty()) {
            result++;
        }

        return result;
    }
}