import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));

            if (stack.isEmpty()) {
                if(str.equals(")")) {
                    return false;
                }
                
                stack.push(str);
            } else {
                if (str.equals("(")) {
                    stack.push(str);
                } else {
                    if (stack.peekLast().equals("(")) {
                        stack.pop();
                    }    
                }
            }
        }

        return stack.size() > 0 ? false : true;
    }
}