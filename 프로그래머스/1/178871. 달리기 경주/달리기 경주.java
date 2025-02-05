import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String call : callings) {
            int idx = map.get(call);
            int targetIdx = idx - 1;

            String temp = players[idx];
            players[idx] = players[targetIdx];
            players[targetIdx] = temp;

            map.put(call, targetIdx);
            map.put(players[idx], idx);
        }

        return players;
    }
}