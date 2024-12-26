import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] arr = new int[commands.length];
        
        for(int l = 0; l < commands.length; l++) {
            int i = commands[l][0] - 1;
            int j = commands[l][1];
            int k = commands[l][2] - 1;

            int[] copy = Arrays.copyOfRange(array, i, j);
            Arrays.sort(copy);

            arr[l] = copy[k];
        }

        return arr;
    }
}