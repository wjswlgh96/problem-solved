class Solution {
    public int solution(String t, String p) {
        int count = 0;
        for(int i = 0; i < t.length() - p.length() + 1; i++) {
            String str = t.substring(i, p.length() + i);
            if(str.compareTo(p) <= 0) {
                count++;
            }
        }
        
        return count;
    }
}