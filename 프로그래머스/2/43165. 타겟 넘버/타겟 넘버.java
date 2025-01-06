import java.util.ArrayList;

class Solution {
    static int count;
    
    public int solution(int[] numbers, int target) {
        count = 0;
        DFS(numbers, 0, 0, target);
        return count;
    }
    
     public static void DFS(int[] numbers, int depth, int currentSum, int target) {
        if (depth == numbers.length) {
            if (currentSum == target) {
                count++;
            }
            return;
        }

        DFS(numbers, depth + 1, currentSum + numbers[depth], target);
        DFS(numbers, depth + 1, currentSum - numbers[depth], target);
    }
}