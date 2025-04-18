class Solution {
    public int solution(int n) {
        int[] arr = new int[100_001];
        arr[0] = 0;
        arr[1] = 1;
        
        for(int i = 2; i < 100_001; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
        }
        
        return arr[n];
    }
}