class Solution {
    public int solution(int n) {
        int sum = 1;
        
        if(n == 1 || n == 2) {
            return n == 1 ? 1 : 2;
        }
        
        for(int i = 2; i <= n / 2; i++) {
            if(n % i == 0) {
                sum += i;
            }
        }
        
        return n == 0 ? 0 : (sum + n);
    }
}