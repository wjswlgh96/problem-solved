class Solution {
    public long solution(int a, int b) {
        if(a == b) {
            return a;
        }
               
        double result = (double) (a + b) * ((Math.abs(a - b) + 1.0) / 2);
        return (long) result;
    }
}