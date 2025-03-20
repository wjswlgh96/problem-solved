class Solution {
    
    static int[] A;
    static int count = 0;
    
    public int solution(String numbers) {
        int length = 10_000_000;
        A = new int[length];
        for (int i = 2; i < length; i++) {
            A[i] = i;
        }

        for (int i = 0; i <= Math.sqrt(length); i++) {
            if(A[i] == 0) continue;

            for (int j = i + i; j < length; j = j + i) {
                A[j] = 0;
            }
        }

        char[] digits = numbers.toCharArray();
        boolean[] used = new boolean[digits.length];

        combinations(digits, "", used);

        return count;
    }
    
    static void combinations(char[] digits, String current, boolean[] used) {
        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            if (A[num] != 0) {
                A[num] = 0;
                count++;
            }
        }

        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                used[i] = true;
                combinations(digits, current + digits[i], used);
                used[i] = false;
            }
        }
    }
}