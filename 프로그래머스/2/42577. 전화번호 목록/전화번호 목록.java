import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for (String s : phone_book) {
            set.add(s);
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : set) {
            char[] arr = s.toCharArray();
            for(int i = 0; i < arr.length - 1; i++) {
                sb.append(arr[i]);
                if (set.contains(sb.toString())) {
                    return false;
                }
            }
            sb.setLength(0);
        }
        
        return true;
    }
}