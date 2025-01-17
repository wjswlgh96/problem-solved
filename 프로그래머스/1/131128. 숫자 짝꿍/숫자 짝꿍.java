import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> xMap = new HashMap();
        Map<String, Integer> yMap = new HashMap();

        for (int i = 0; i < X.length(); i++) {
            String s = String.valueOf(X.charAt(i));
            xMap.put(s, xMap.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < Y.length(); i++) {
            String s = String.valueOf(Y.charAt(i));
            yMap.put(s, yMap.getOrDefault(s, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        for (String s : xMap.keySet()) {
            if (yMap.containsKey(s)) {
                int min = Math.min(xMap.get(s), yMap.get(s));
                result.append(s.repeat(min));
            }
        }


        char[] charArr = result.toString().toCharArray();
        Arrays.sort(charArr);
        result = new StringBuilder(new String(charArr)).reverse();

        if (result.length() == 0) {
            return "-1";
        } else if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }
}