import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int kMax;
    static int[][] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
        }

        int temp = 1;
        kMax = 0;
        while (temp <= N) {     // 최대 가능한 depth 구하기 2^k
            temp <<= 1;
            kMax++;
        }

        parent = new int[kMax + 1][N + 1];
        BFS(1);
        for (int k = 1; k < kMax; k++) {    // 점화식 공식
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(LCA(a, b) + "\n");
        }

        bw.flush();
        br.close();
    }

    private static int LCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int k = kMax; k >= 0; k--) {       // depth 맞추기
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }

        for (int k = kMax; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int result = a;
        if (a != b) {
            result = parent[0][result];
        }

        return result;
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        int level = 1;
        int nowSize = 1;
        int count = 0;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            for (Integer next : tree[nowNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = level;
                    parent[0][next] = nowNode;
                    queue.offer(next);
                }
            }

            count++;
            if (count == nowSize) {
                count = 0;
                nowSize = queue.size();
                level++;
            }
        }
    }
}
