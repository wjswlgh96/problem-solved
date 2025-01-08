import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int target = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                set.add(target + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::valueOf).toArray();
    }
}