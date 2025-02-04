import java.io.*;
import java.util.*;

public class Main {

    static int[] visited;
    static List<Integer>[] A;
    static int N, M, K, X;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        A = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
        }
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }
        BFS(X);
        for (int i = 0; i <= N; i++) {
            if (visited[i] == K) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            result.sort(null);
            for (Integer i : result) {
                System.out.println(i);
            }
        }
    }

    static void BFS(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node]++;
        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            for (int i : A[currNode]) {
                if (visited[i] == -1) {
                    visited[i] = visited[currNode] + 1;
                    queue.offer(i);
                }
            }
        }
    }
}
