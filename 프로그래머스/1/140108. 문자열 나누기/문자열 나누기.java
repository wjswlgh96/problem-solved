
class Solution {
    public int solution(String s) {
        int result = 0;
        int xCount = 0;
        int otherCount = 0;

        char first = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == first) {
                xCount++;
            } else {
                otherCount++;
            }

            if (xCount == otherCount) {
                result++;

                if (i + 1 < s.length()) {
                    first = s.charAt(i + 1);
                }
                xCount = 0;
                otherCount = 0;
            }
        }

        if (xCount > 0) {
            result++;
        }

        return result;
    }
}