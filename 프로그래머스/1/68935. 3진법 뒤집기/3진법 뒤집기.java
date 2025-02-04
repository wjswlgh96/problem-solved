class Solution {
    public int solution(int n) {
        String str = toTernary(n);
        int count = 0;
        int result = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(str.charAt(i));
            result += digit * (int) Math.pow(3, count++);
        }
        
        return result;
    }
    
    private static String toTernary(int n) {
        if(n < 3) {
            return Integer.toString(n);
        }
        
        return (n % 3) + toTernary(n / 3);
    }
}