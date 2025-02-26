import java.util.*;

class Solution {
    public int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String newStr = s.substring(i) + s.substring(0, i);
            for (int j = 0; j < newStr.length(); j++) {
                char c = newStr.charAt(j);

                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                count++;
            }

            stack.clear();
        }

        return count;
    }
}