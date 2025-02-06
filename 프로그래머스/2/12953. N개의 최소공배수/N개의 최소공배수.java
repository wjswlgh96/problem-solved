class Solution {
    public static int solution(int[] arr) {
        int result = 1;

        for (int i = 0; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        
        return result;
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}