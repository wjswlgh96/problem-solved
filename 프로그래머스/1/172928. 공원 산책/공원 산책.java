class Solution {
    public static int[] solution(String[] park, String[] routes) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                char c = park[i].charAt(j);

                if (c == 'S') {
                    x = j;
                    y = i;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String op = String.valueOf(routes[i].charAt(0));
            int n = routes[i].charAt(2) - '0';
            int currX = x;
            int currY = y;

            boolean isChecked = true;
            while (n != 0) {
                if (op.equals("N")) {
                    if ((0 > currY - 1) || !validation(park[currY - 1].charAt(currX))) {
                        isChecked = false;
                        break;
                    }

                    n--;
                    currY--;
                } else if (op.equals("S")) {
                    if ((park.length <= currY + 1) || !validation(park[currY + 1].charAt(currX))) {
                        isChecked = false;
                        break;
                    }

                    n--;
                    currY++;
                } else if (op.equals("W")) {
                    if ((0 > currX - 1) || !validation(park[currY].charAt(currX - 1))) {
                        isChecked = false;
                        break;
                    }

                    n--;
                    currX--;
                } else {
                    if ((park[currY].length() <= currX + 1) || !validation(park[currY].charAt(currX + 1))) {
                        isChecked = false;
                        break;
                    }

                    n--;
                    currX++;
                }
            }

            if (isChecked) {
                x = currX;
                y = currY;
            }
        }

        return new int[]{y, x};
    }

    private static boolean validation(char c) {
        if (c == 'X') {
            return false;
        }

        return true;
    }
}