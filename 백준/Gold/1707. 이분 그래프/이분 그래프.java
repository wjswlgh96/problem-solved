import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;
            for (int j = 1; j <= V; j++) {
                A[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                str = br.readLine().split(" ");
                int start = Integer.parseInt(str[0]);
                int end = Integer.parseInt(str[1]);

                A[start].add(end);
                A[end].add(start);
            }

            for (int j = 1; j <= V; j++) {
                if (isEven) {
                    DFS(j);
                } else {
                    break;
                }
            }

            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    static void DFS(int index) {
        visited[index] = true;
        for (int i : A[index]) {
            if (!visited[i]) {
                check[i] = (check[index] + 1) % 2;
                DFS(i);
            } else if (check[index] == check[i]) {
                isEven = false;
            }
        }
    }
}
