import java.util.ArrayList;

class Solution {
    static int n;
    static ArrayList<Integer>[] A;
    static int count;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        A = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            A[i].add(numbers[i]);
            A[i].add(numbers[i] * -1);
        }

        DFS(A[0].get(0), 0, target);
        DFS(A[0].get(1), 0, target);

        return count;
    }
    
    public static void DFS(int num, int depth, int target) {
        if ((n - 1) == depth) {
            if(num == target) {
                count++;
            }
            return;
        }

        DFS((num + A[depth + 1].get(0)), depth + 1, target);
        DFS((num + A[depth + 1].get(1)), depth + 1, target);
    }
}