import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerToIndex = new HashMap<>();
        Map<Integer, String> indexToPlayer = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerToIndex.put(players[i], i);
            indexToPlayer.put(i, players[i]);
        }

        for (int i = 0; i < callings.length; i++) {
            String call = callings[i];
            int idx = playerToIndex.get(call);
            int targetIdx = idx - 1;
            String target = indexToPlayer.get(targetIdx);

            playerToIndex.put(call, targetIdx);
            playerToIndex.put(target, idx);

            indexToPlayer.put(targetIdx, call);
            indexToPlayer.put(idx, target);
        }

        String[] result = new String[players.length];
        for (Map.Entry<String, Integer> entry : playerToIndex.entrySet()) {
            result[entry.getValue()] = entry.getKey();
        }

        return result;
    }
}