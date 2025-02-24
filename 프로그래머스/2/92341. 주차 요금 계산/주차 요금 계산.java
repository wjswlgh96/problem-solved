import java.util.*;

class Solution {
    
    private static final Integer MAX_TIMES = 23 * 60 + 59;
    
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        double unitMinute = fees[2];
        int unitFee = fees[3];

        Map<String, Integer> map = new TreeMap<>();

        for (String record : records) {
            String[] temp = record.split(" ");

            int base = temp[2].equals("IN") ? -1 : 1;
            base *= parseTimeToInt(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + base);
        }

        int i = 0;
        int[] result = new int[map.size()];
        for (Integer time : map.values()) {
            if (time < 1) {
                time += MAX_TIMES;
            }

            if (time > baseTime) {
                result[i] = baseFee + (int) Math.ceil((time - baseTime) / unitMinute) * unitFee;
            } else {
                result[i] = baseFee;
            }

            i++;
        }

        return result;
    }

    public static int parseTimeToInt(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}