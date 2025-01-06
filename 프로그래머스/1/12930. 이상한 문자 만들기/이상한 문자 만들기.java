class Solution {
    public String solution(String s) {
        char[] charArr = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        int j = 0;
        
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            
            if(c == ' ') {
                sb.append(c);
                j = 0;
                continue;
            }
            
            if(j % 2 == 0) {
                sb.append(String.valueOf(Character.toUpperCase(c)));                
            } else {
                sb.append(String.valueOf(Character.toLowerCase(c)));
            }
            
            j++;
        }
        
        return sb.toString();
    }
}