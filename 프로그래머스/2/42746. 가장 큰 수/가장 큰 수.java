import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            return Integer.parseInt(b + a) - Integer.parseInt(a + b);
        });

        String result = String.join("", arr);
        return result.charAt(0) == '0' ? "0" : result;
    }
}