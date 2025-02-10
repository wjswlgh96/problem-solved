import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> sumSet = new HashSet<>();

        int[] circular = new int[n * 2];
        for (int i = 0; i < n; i++) {
            circular[i] = elements[i];
            circular[i + n] = elements[i];
        }

        for (int len = 1; len <= n; len++) {
            int sum = 0;

            for (int k = 0; k < len; k++) {
                sum += circular[k];
            }
            sumSet.add(sum);

            for (int start = 1; start < n; start++) {
                sum = sum - circular[start - 1] + circular[start + len - 1];
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}