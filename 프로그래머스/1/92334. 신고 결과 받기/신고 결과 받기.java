import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportTarget = new HashMap<>();
        Map<String, Integer> reportCnt = new HashMap<>();

        for (String id : id_list) {
            reportTarget.put(id, new HashSet<>());
            reportCnt.put(id, 0);
        }

        for (String r : report) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String target = parts[1];

            if (reportTarget.get(reporter).add(target)) {
                reportCnt.put(target, reportCnt.get(target) + 1);
            }
        }

        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            int count = 0;

            for (String target : reportTarget.get(reporter)) {
                if (reportCnt.get(target) >= k) {
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }
}