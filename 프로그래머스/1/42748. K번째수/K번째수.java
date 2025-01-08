import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
       int[] arr = new int[commands.length];

        for(int z = 0; z < commands.length; z++) {
            int i = commands[z][0] - 1;
            int j = commands[z][1];
            int k = commands[z][2] - 1;

            int[] copy = Arrays.copyOfRange(array, i, j);
            Arrays.sort(copy);

            arr[z] = copy[k];
        }

        return arr;
    }
}