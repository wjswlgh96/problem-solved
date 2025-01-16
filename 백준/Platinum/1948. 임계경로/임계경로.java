import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> A = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverseA = new ArrayList<>();

        int[] indegree= new int[n + 1];
        for (int i = 0; i <= n; i++) {
            A.add(new ArrayList<>());
            reverseA.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A.get(s).add(new Node(e, v));
            reverseA.get(e).add(new Node(s, v));
            indegree[e]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        int[] result = new int[n + 1];

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Node next : A.get(now)) {
                indegree[next.e]--;
                result[next.e] = Math.max(result[next.e], result[now] + next.v);
                if (indegree[next.e] == 0) {
                    queue.offer(next.e);
                }
            }
        }


        int resultCount= 0;
        boolean[] visited = new boolean[n + 1];
        queue = new ArrayDeque<>();
        queue.offer(end);
        visited[end] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Node next : reverseA.get(now)) {
                if (result[next.e] + next.v == result[now]) {
                    resultCount++;

                    if (!visited[next.e]) {
                        visited[next.e] = true;
                        queue.offer(next.e);
                    }
                }
            }
        }

        System.out.println(result[end]);
        System.out.println(resultCount);
    }

    static class Node {
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
    }
}
