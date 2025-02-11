import java.util.*;

class Solution {
   public int solution(int[] citations) {
        Integer[] arr = Arrays.stream(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);
        
        for (int i = 0; i < arr.length; i++) {
            if (i >= arr[i]) {
                return i;
            }
        }

        return arr.length;
    }
}