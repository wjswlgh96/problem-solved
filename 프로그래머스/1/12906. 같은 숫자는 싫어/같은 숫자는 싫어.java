import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            Integer num = stack.get(stack.size() - 1);
            if (num.equals(arr[i])) {
                continue;
            } else {
                stack.push(arr[i]);
            }
        }

        int[] result = new int[stack.size()];
        for(int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}