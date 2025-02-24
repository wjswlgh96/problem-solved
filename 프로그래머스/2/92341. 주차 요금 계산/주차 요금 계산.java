import java.util.*;

class Solution {
    
    private static final Integer MAX_TIMES = 23 * 60 + 59;
    
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        double unitMinute = fees[2];
        int unitFee = fees[3];

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> resultTimes = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        for (String record : records) {
            String[] splits = record.split(" ");
            String[] times = splits[0].split(":");
            Integer parseMinute = (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
            String key = splits[1];
            String command = splits[2];

            sb.append(parseMinute).append(" ").append(command);
            if (map.containsKey(key)) {
                map.get(key).add(sb.toString());
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(sb.toString());
                resultTimes.put(key, resultTimes.getOrDefault(key, 0));
            }

            sb.setLength(0);
        }

        for (String key : map.keySet()) {
            int length = map.get(key).size();

            int calcTime = 0;
            for (int i = 0; i < length; i++) {
                String[] splits = map.get(key).get(i).split(" ");
                Integer time = Integer.parseInt(splits[0]);
                String command = splits[1];

                if (i == length - 1 && command.equals("IN")) {
                    int resultTime = MAX_TIMES - time;
                    resultTimes.put(key, resultTimes.get(key) + resultTime);
                } else if (command.equals("IN")) {
                    calcTime = time;
                } else if (command.equals("OUT")) {
                    calcTime = Math.abs(calcTime - time);
                    resultTimes.put(key, resultTimes.get(key) + calcTime);
                    calcTime = 0;
                }
            }
        }

        int[] result = new int[resultTimes.size()];
        int i = 0;
        for (String key : resultTimes.keySet()) {
            int value = resultTimes.get(key);

            if (value > baseTime) {
                result[i] = baseFee + (int) Math.ceil((value - baseTime) / unitMinute) * unitFee;
            } else {
                result[i] = baseFee;
            }

            i++;
        }

        return result;
    }
}