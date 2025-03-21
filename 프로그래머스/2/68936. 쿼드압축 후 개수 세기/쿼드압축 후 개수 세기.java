class Solution {
    
    private static int[] answer = new int[2];
    
    public static int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    private static void compress(int[][] arr, int x, int y, int size) {
        if (isAllSame(arr, x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }

        int newSize = size / 2;
        compress(arr, x, y, newSize);
        compress(arr, x, y + newSize, newSize);
        compress(arr, x + newSize, y, newSize);
        compress(arr, x + newSize, y + newSize, newSize);
    }

    private static boolean isAllSame(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }
}