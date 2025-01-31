class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String str : split) {
            int value = Integer.parseInt(str);
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        return min + " " + max;
    }
}