class Solution {
    public int solution(int number, int limit, int power) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            count += divisor(i) > limit ? power : divisor(i);
        }

        return count;
    }

    public static int divisor(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == num / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }

        return count;
    }
}