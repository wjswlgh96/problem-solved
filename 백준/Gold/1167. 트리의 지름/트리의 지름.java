import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int n;
    static int maxDistance;
    static int fallNode;

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

        DFS(1, 0);
        visited = new boolean[n + 1];
        maxDistance = 0;
        DFS(fallNode, 0);
        System.out.println(maxDistance);
    }

    public static void DFS(int node, int distance) {
        if (distance > maxDistance) {
            maxDistance = distance;
            fallNode = node;
        }

        visited[node] = true;
        for (Node n : list[node]) {
            if (!visited[n.edge]) {
                DFS(n.edge, distance + n.distance);
            }
        }
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
