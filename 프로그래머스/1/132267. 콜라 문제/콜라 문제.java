class Solution {
    public int solution(int a, int b, int n) {
        int result = 0;

        while (a <= n) {
            result += n / a * b;
            n = (n % a) + (n / a * b);
        }

        return result;
    }
}