import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for (int i = 0; i < X.length(); i++) {
            int idx = X.charAt(i) - '0';
            xArr[idx]++;
        }

        for (int i = 0; i < Y.length(); i++) {
            int idx = Y.charAt(i) - '0';
            yArr[idx]++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < xArr.length; i++) {
            int xValue = xArr[i];
            int yValue = yArr[i];

            if (xValue == 0 || yValue == 0) {
                continue;
            }

            int min = Math.min(xValue, yValue);
            result.append(String.valueOf(i).repeat(min));
        }
        
        String str = result.reverse().toString();
        if (str.length() == 0) {
            return "-1";
        } else if (str.charAt(0) == '0') {
            return "0";
        }


        return str;
    }
}