class Solution {
    public int solution(int angle) {
        if(angle == 90 || angle == 180) {
            return (angle == 90) ? 2 : 4;
        } else {
            return (angle < 90) ? 1 : 3;
        }
    }
}