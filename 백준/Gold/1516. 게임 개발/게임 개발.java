import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            A.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1];
        int[] buildTime = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int edge = Integer.parseInt(st.nextToken());
                if (edge == -1) {
                    break;
                }

                A.get(edge).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : A.get(now)) {
                indegree[next]--;

                result[next] = Math.max(result[next], result[now] + buildTime[now]);
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i] + buildTime[i]);
        }
    }
}
