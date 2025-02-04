class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int lcm = (n * m) / gcd;
        int[] answer = {gcd, lcm};
        return answer;
    }
    
    public static int gcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if(a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }
}