import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {

            for (int start = 0; start < elements.length; start++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += elements[(start + k) % elements.length];
                }
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}