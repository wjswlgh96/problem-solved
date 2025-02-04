class Solution {
    public int solution(int[][] sizes) {
        int[][] newSizes = new int[sizes.length][2];
        int[] maxSizes = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        for(int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if(w > h) {
                newSizes[i][0] = w;
                newSizes[i][1] = h;
            } else {
                newSizes[i][0] = h;
                newSizes[i][1] = w;
            }
        }
        
        for(int i = 0; i < newSizes.length; i++) {
            int w = newSizes[i][0];
            int h = newSizes[i][1];
            
            if(w > maxSizes[0]) {
                maxSizes[0] = w;
            }
            
            if(h > maxSizes[1]) {
                maxSizes[1] = h;
            }
        }
        
        return maxSizes[0] * maxSizes[1];
    }
}