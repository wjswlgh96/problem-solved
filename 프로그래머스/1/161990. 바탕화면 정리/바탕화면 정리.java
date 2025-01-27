class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char c = wallpaper[i].charAt(j);

                if (c == '#') {
                    if (luy > i) {
                        luy = i;
                    }
                    if (rdy <= i) {
                        rdy = i + 1;
                    }
                    if (lux > j) {
                        lux = j;
                    }
                    if (rdx <= j) {
                        rdx = j + 1;
                    }
                }
            }
        }

        answer[0] = luy;
        answer[1] = lux;
        answer[2] = rdy;
        answer[3] = rdx;
        return answer;
    }
}