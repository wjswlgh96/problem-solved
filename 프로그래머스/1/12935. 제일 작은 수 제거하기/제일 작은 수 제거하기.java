class Solution {
    public int[] solution(int[] arr) {
        if(arr.length <= 1) {
            int[] result = {-1};
            return result;
        }
        
        int min = Integer.MAX_VALUE;
        for(int num : arr) {
            if(min > num) {
                min = num;
            }
        }
        
        int[] result = new int[arr.length - 1];
        int index = 0;
        for(int num : arr) {
            if(min != num) {
                result[index++] = num;
            }
        }
        
        return result;
    }
}