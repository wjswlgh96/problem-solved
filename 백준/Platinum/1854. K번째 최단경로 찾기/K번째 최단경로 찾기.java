import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N, M, K;
        int[][] W = new int[1001][1001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N + 1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };

        for (int i = 0; i <= N; i++) {
            distQueue[i] = new PriorityQueue<>(K, cp);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            W[s][e] = v;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        distQueue[1].add(0);

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            for (int i = 1; i <= N; i++) {
                if (W[curr.node][i] != 0) {
                    if (distQueue[i].size() < K) {
                        distQueue[i].add(curr.cost + W[curr.node][i]);
                        pq.add(new Node(i, curr.cost + W[curr.node][i]));
                    } else if (distQueue[i].peek() > curr.cost + W[curr.node][i]) {
                        distQueue[i].poll();
                        distQueue[i].add(curr.cost + W[curr.node][i]);
                        pq.add(new Node(i, curr.cost + W[curr.node][i]));
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distQueue[i].size() == K) {
                bw.write(distQueue[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static class Node implements Comparable<Node> {

        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "node=" + node +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.cost < o.cost ? -1 : 1;
        }
    }
}
