class Solution {
    public String solution(int n) {
        return "수박".repeat((int)n / 2 + 1).substring(0, n);
    }
}