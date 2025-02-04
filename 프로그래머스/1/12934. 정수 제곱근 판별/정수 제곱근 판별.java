class Solution {
    public long solution(long n) {
        int result = (int) Math.sqrt(n) + 1;
        return Math.sqrt(n) % 1 == 0.0 ? (long) Math.pow(result, 2) : -1;
    }
}