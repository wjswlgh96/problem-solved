import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String base = Integer.toString(n, k);
        String[] splits = base.split("0");
        
        int count = 0;
        for(String s : splits) {
            if(!s.isEmpty() && isPrime(Long.parseLong(s))) {
                count++;
            }
        }
        
        return count;
    }
    
    public static boolean isPrime(long n) {
        if(n < 2) return false;
        
        for(long i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}