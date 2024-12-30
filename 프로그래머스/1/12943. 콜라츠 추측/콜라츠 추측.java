class Solution {
    public int solution(int num) {
        int count = 0;
        long longNum = num;
    
    while(longNum != 1 && count != 500) {
        longNum = longNum % 2 == 0 ? longNum /= 2 : (longNum * 3) + 1;
        count++;
    }
    
        return longNum == 1 ? count : -1;
    }
}