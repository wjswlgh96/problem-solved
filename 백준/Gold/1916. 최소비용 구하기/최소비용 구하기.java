import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<ArrayList<Node>> A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 노드 갯수
        int m = Integer.parseInt(br.readLine());    // 엣지 갯수
        A = new ArrayList<>();
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            A.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A.get(u).add(new Node(e, v));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = dijkstra(start, end);
        System.out.println(result);
        br.close();
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.e;

            if (!visited[now]) {
                visited[now] = true;
                for (Node n : A.get(now)) {
                    if (!visited[n.e] && distance[n.e] > distance[now] + n.v) {
                        distance[n.e] = distance[now] + n.v;
                        pq.add(new Node(n.e, distance[n.e]));
                    }
                }
            }
        }

        return distance[end];
    }

    private static class Node implements Comparable<Node> {
        int e;
        int v;

        public Node(int e, int v) {
            this.e = e;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", v=" + v +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if (this.v > o.v) {
                return 1;
            }

            return -1;
        }
    }

}
