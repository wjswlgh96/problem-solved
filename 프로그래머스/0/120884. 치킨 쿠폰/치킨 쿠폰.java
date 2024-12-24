class Solution {
    public int solution(int chicken) {
        int result = 0;
        
        while(chicken > 9) {
            result += (int) Math.floor(chicken / 10);
            chicken = (int) Math.floor(chicken / 10) + (chicken % 10);
        }
        
        return result;
    }
}