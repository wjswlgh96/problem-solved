import java.util.*;

public class Solution {
    public int solution(int n) {
        char[] charArr = String.valueOf(n).toCharArray();
        int sum = 0;

        for(int i = 0; i < charArr.length; i++) {
            sum += Integer.parseInt(String.valueOf(charArr[i]));
        }

        return sum;
    }
}