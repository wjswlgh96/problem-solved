import java.util.*;

class Solution {
   public int solution(int[] citations) {
        Arrays.sort(citations);

        int result = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int min = (int) Math.min(citations[i], citations.length - i);
            if(result < min) result = min;
        }

        return result;
    }
}