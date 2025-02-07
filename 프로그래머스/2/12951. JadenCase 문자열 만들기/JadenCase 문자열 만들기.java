class Solution {
    public String solution(String s) {
        String[] split = s.split(" ", -1);
        String[] result = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            if(split[i].isEmpty()) {
                result[i] = "";
            } else {
                result[i] = String.valueOf(Character.toUpperCase(split[i].charAt(0))) + split[i].substring(1).toLowerCase();
            }
        }

        return String.join(" ", result);
    }
}