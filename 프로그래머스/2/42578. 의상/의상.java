import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            String item = clothes[i][0];

            if (map.containsKey(type)) {
                map.get(type).add(item);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(item);
                map.put(type, list);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort(null);

        int result = 1;
        for(int i = 0; i < list.size(); i++) {
            int size = map.get(list.get(i)).size() + 1;
            result *= size;
        }
        
        return result - 1;
    }
}