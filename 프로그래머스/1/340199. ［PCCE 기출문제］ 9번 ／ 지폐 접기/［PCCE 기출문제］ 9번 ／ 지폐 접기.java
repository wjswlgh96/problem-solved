class Solution {
    public int solution(int[] wallet, int[] bill) {
        int walletX = wallet[0];
        int walletY = wallet[1];
        
        int billX = bill[0];
        int billY = bill[1];
        
        int count = 0;
        while((billX > walletX || billY > walletY) &&
              (billY > walletX || billX > walletY)) {
            
            if(billX > billY) {
                billX = (int) Math.floor(billX / 2);
            } else {
                billY = (int) Math.floor(billY / 2);
            }
            
            count++;
        }
        
        return count;
    }
}