import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    
    public static int solution(int[][] maps) {
        int yLength = maps.length;
        int xLength = maps[0].length;
        visited = new boolean[yLength][xLength];
        BFS(maps,0, 0, xLength, yLength);
        return maps[yLength - 1][xLength - 1] < 2 ? -1 : maps[yLength - 1][xLength - 1];
    }

    public static void BFS(int[][] maps, int x, int y, int xLength, int yLength) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= yLength || nextY >= xLength) continue;
                if(visited[nextX][nextY] || maps[nextX][nextY] == 0) continue;

                visited[nextX][nextY] = true;
                maps[nextX][nextY] = maps[nowX][nowY] + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }
    }
}