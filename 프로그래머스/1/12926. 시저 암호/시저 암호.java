class Solution {
    public String solution(String s, int n) {
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArr) {
            if(c == ' ') {
                sb.append(" ");
                continue;
            }
            
            int charCode = (int) c;
            int result = charCode + n;
            if (charCode <= 90) {
                sb.append(String.valueOf((result) > 90 ? (char) ((int) result - 26) : (char) result));
            } else {
                sb.append(String.valueOf((result) > 122 ? (char) ((int) result - 26) : (char) result));
            }
        }
        
        return sb.toString();
    }
}