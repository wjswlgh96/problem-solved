import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] A;
    static boolean[] visited;
    static int delete = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        visited = new boolean[N];
        int root = 0;

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());

            if (v != -1) {
                A[i].add(v);
                A[v].add(i);
            } else {
                root = i;
            }
        }

        delete = Integer.parseInt(br.readLine());
        if (delete == root) {
            bw.write("0");
        } else {
            DFS(root);
            bw.write(result + "");
        }

        bw.close();
        br.close();
    }

    private static void DFS(int node) {
        visited[node] = true;
        int child = 0;
        for (int i : A[node]) {
            if (!visited[i] && i != delete) {
                child++;
                DFS(i);
            }
        }

        if (child == 0) {
            result++;
        }
    }
}
