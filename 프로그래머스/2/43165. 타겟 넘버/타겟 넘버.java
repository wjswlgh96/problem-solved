import java.util.ArrayList;

class Solution {
    
    public int solution(int[] numbers, int target) {
        return DFS(numbers, 0, 0, target);
    }
    
    public static int DFS(int[] numbers, int depth, int sum, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                return 1;
            }
            
            return 0;
        }
        
        return DFS(numbers, depth + 1, sum + numbers[depth], target) + DFS(numbers, depth + 1, sum - numbers[depth], target);
    }
}