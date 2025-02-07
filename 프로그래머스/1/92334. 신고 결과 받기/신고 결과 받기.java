import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportTargetMap = new HashMap<>();
        Map<String, Integer> reportCntMap = new HashMap<>();
        for (String id : id_list) {
            reportTargetMap.put(id, new HashSet<>());
            reportCntMap.put(id, 0);
        }

        for (String r : report) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String target = parts[1];
            
            if (reportTargetMap.get(reporter).contains(target)) {
                continue;
            }

            reportTargetMap.get(reporter).add(target);
            reportCntMap.put(target, reportCntMap.get(target) + 1);
        }

        List<String> bannedUsers = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : reportCntMap.entrySet()) {
            if (entry.getValue() >= k) {
                bannedUsers.add(entry.getKey());
            }
        }

        Map<String, Integer> reportResultMap = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : reportTargetMap.entrySet()) {
            for (String bannedUser : bannedUsers) {
                if(entry.getValue().contains(bannedUser)) {
                    reportResultMap.put(entry.getKey(), reportResultMap.getOrDefault(entry.getKey(), 0) + 1);
                }
            }
        }

        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            result[i] = reportResultMap.getOrDefault(reporter, 0);
        }

        return result;
    }
}