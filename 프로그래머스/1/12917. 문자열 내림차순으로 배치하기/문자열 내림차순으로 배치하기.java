import java.util.*;

class Solution {
    public String solution(String s) {
       char[] charArr = s.toCharArray();
        Arrays.sort(charArr);

        int i = 0;
        int j = charArr.length - 1;

        while(i < j) {
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
            i++;
            j--;
        }
        String result = new String(charArr);
        return result;
    }
}