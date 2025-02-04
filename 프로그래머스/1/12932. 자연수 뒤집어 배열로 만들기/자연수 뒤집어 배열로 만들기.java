class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int[] result = new int[str.length()];

        int j = 0;
        for(int i = str.length() - 1; i >= 0; i--) {
            result[j++] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        return result;
    }
}