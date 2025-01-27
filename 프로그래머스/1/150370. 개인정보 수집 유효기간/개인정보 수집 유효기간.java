import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] rm = terms[i].split(" ");
            termsMap.put(rm[0], Integer.parseInt(rm[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] dm = privacies[i].split(" ");
            String[] date = dm[0].split("[.]");
            String newDate = "";
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]) + termsMap.get(dm[1]);
            int day = Integer.parseInt(date[2]) - 1;

            if (day < 1) {
                month--;
                day = 28;

                if (month == 0) {
                    year--;
                    month = 12;
                }
            }

            while (month > 12) {
                year++;
                month -= 12;
            }

            newDate = year + "." + String.format("%02d", month) + "." + String.format("%02d", day);
            if (newDate.compareTo(today) < 0) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}