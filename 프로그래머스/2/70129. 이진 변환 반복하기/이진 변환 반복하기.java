class Solution {
    public int[] solution(String s) {
         int count = 0;
        int zeroCount = 0;

        int length = 0;
        while (!s.equals("1")) {
            count++;
            zeroCount += s.length();

            s = s.replaceAll("0", "");
            length = s.length();
            s = Integer.toBinaryString(length);

            zeroCount -= length;
        }

        return new int[]{count, zeroCount};
    }
}