import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        int canGetLength = nums.length / 2;

        for (int num : nums) {
            hash.add(num);
        }

        boolean isOver = hash.size() > canGetLength;

        return isOver ? canGetLength : hash.size();
    }
}