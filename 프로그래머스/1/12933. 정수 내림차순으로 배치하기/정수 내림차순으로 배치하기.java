import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = String.valueOf(n).toCharArray();

        Arrays.sort(charArr);
        String str = sb.append(charArr).reverse().toString();

        return Long.valueOf(str);
    }
}