import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        parent = new int[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            queue.add(new Edge(s, e, v));
        }

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int sum = 0;
        int edgeCount = 0;

        while (edgeCount < V - 1) {
            Edge curr = queue.poll();
            if (find(curr.start) != find(curr.end)) {
                union(curr.start, curr.end);
                sum += curr.value;
                edgeCount++;
            }
        }

        System.out.println(sum);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int b) {
        if (b == parent[b]) {
            return b;
        } else {
            return parent[b] = find(parent[b]);
        }
    }

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}
