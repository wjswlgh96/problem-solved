import java.io.*;
import java.util.*;

public class Main {

    static int[] sender = {0, 0, 1, 1, 2, 2};       // A, B, C
    static int[] receiver = {1, 2, 0, 2, 0, 1};     // 받는 물통
    static boolean[][] visited = new boolean[201][201];
    static boolean[] answer = new boolean[201];
    static int[] now = new int[3];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        BFS();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    static void BFS() {
        Queue<AB> queue = new ArrayDeque<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;

            for (int i = 0; i < 6; i++) {
                int[] next = {A, B, C};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;

                if (next[receiver[i]] > now[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    static class AB {
        int A;
        int B;
        public AB(int a, int b) {
            A = a;
            B = b;
        }
    }
}
