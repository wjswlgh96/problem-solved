import java.io.*;
import java.util.*;

public class Main {

    static List<Node>[] list;
    static boolean[] visited;
    static long lcm = 1;
    static long[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        visited = new boolean[N];
        result = new long[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<Node>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, p, q));
            list[b].add(new Node(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }

        result[0] = lcm;
        DFS(0);

        long gcdAll = result[0];
        for (int i = 1; i < N; i++) {
            gcdAll = gcd(gcdAll, result[i]);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] / gcdAll + " ");
        }
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    static void DFS(int node) {
        visited[node] = true;
        for (Node n : list[node]) {
            int next = n.getB();
            if (!visited[next]) {
                result[next] = result[node] * n.getQ() / n.getP();
                DFS(next);
            }
        }
    }

    static class Node {
        int b;
        int p;
        int q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "b=" + b +
                    ", p=" + p +
                    ", q=" + q +
                    '}';
        }
    }
}
