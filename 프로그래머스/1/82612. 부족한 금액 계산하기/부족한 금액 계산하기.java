class Solution {
    public long solution(int price, int money, int count) {
        long sum = 0L;
        for(int i = 1; i <= count; i++) {
            sum += (i * price);
        }
        
        long result = money - sum;
        
        return result < 0 ? (long) Math.abs(result) : 0;
    }
}