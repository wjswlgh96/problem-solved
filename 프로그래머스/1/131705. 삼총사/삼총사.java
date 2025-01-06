class Solution {
    public int solution(int[] number) {
        int count = 0;
        
        for(int i = 0; i < number.length - 2; i++) {
            int curr = number[i];
            
            for(int j = i + 1; j < number.length - 1; j++) {
                int next = number[j];
                
                for(int k = j + 1; k < number.length; k++) {
                    int nNext = number[k];
                    
                    if((curr + next + nNext) == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}