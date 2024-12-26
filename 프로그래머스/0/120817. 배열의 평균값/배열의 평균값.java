class Solution {
    public double solution(int[] numbers) {
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }
        
        double average = (double) sum / numbers.length;
        return average;
    }
}