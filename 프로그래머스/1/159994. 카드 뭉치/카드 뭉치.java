import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> oneStack = new ArrayDeque<>();
        Deque<String> twoStack = new ArrayDeque<>();
        Deque<String> goalStack = new ArrayDeque<>();

        for (int i = 0; i < cards1.length; i++) {
            oneStack.offerLast(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            twoStack.offerLast(cards2[i]);
        }
        for (int i = 0; i < goal.length; i++) {
            goalStack.offerLast(goal[i]);
        }

        while (!goalStack.isEmpty()) {
            String curr = goalStack.pollFirst();

            if (!oneStack.isEmpty() && oneStack.peekFirst().equals(curr)) {
                oneStack.pollFirst();
            } else if (!twoStack.isEmpty() && twoStack.peekFirst().equals(curr)) {
                twoStack.pollFirst();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}