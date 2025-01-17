import java.io.*;
import java.util.*;

public class Main {

    static int V, E;
    static ArrayList<ArrayList<Node>> A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());    // 정점의 갯수
        E = Integer.parseInt(st.nextToken());    // 간선의 갯수

        int start = Integer.parseInt(br.readLine());

        A = new ArrayList<>();
        visited = new boolean[V + 1];
        distance = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            A.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A.get(u).add(new Node(v, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int end = current.e;

            if(visited[end]) continue;
            visited[end] = true;

            for (Node temp : A.get(end)) {
                int next = temp.e;
                int value = temp.v;

                if (distance[next] > distance[end] + value) {
                    distance[next] = value + distance[end];
                    queue.add(new Node(next, distance[next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                bw.write(distance[i] + "\n");
            } else {
                bw.write("INF\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static class Node implements Comparable<Node> {
        int e;  // 도착
        int v;  // 가중치

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
