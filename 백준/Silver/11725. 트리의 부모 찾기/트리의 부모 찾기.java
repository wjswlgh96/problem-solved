import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] A;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.close();
        br.close();
    }

    private static void DFS(int start) {
        visited[start] = true;
        for (int i : A[start]) {
            if (!visited[i]) {
                parent[i] = start;
                DFS(i);
            }
        }
    }
}
