class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {
            count++;
            zeroCount += s.replaceAll("1", "").length();

            s = Integer.toBinaryString(s.replaceAll("0", "").length());
        }

        return new int[]{count, zeroCount};
    }
}