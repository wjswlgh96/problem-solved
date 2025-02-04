class Solution {
    public String solution(String s) {
        boolean isEven = s.length() % 2 == 0;
        int middle = (int) Math.floor(s.length() / 2);
        
        return isEven ? s.substring(middle - 1, middle + 1) : s.substring(middle, middle + 1);
    }
}