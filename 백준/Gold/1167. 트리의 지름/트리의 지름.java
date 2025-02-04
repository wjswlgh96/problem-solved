import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        String[] inputs;
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");

            for (int j = 1; j < inputs.length; j += 2) {
                String s = inputs[j];

                if (s.equals("-1")) {
                    break;
                } else {
                    int e = Integer.parseInt(s);
                    int d = Integer.parseInt(inputs[j + 1]);
                    list[Integer.parseInt(inputs[0])].add(new Node(e, d));
                }
            }
        }

        int[] bfs = BFS(1);
        visited = new boolean[n + 1];
        int[] second = BFS(bfs[1]);
        System.out.println(second[0]);
    }

    public static int[] BFS(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[node] = true;
        queue.offer(node);
        int[] distance = new int[n + 1];

        int maxDistance = 0;
        int fallNode = node;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Node n : list[now]) {
                if (!visited[n.edge]) {
                    visited[n.edge] = true;
                    distance[n.edge] = distance[now] + n.distance;

                    if (distance[n.edge] > maxDistance) {
                        maxDistance = distance[n.edge];
                        fallNode = n.edge;
                    }

                    queue.offer(n.edge);
                }
            }
        }

        return new int[] {maxDistance, fallNode};
    }

    public static class Node {
        int edge;
        int distance;

        public Node(int edge, int distance) {
            this.edge = edge;
            this.distance = distance;
        }
    }
}
