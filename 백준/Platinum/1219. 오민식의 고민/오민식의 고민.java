import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int sCity = Integer.parseInt(st.nextToken());
        int eCity = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[M];
        long[] distance = new long[N];
        long[] cityMoney = new long[N];
        Arrays.fill(distance, Long.MIN_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(s, e, v);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cityMoney[i] = Long.parseLong(st.nextToken());
        }

        distance[sCity] = cityMoney[sCity];

        for (int i = 0; i <= N + 100; i++) {
            for (int j = 0; j < M; j++) {
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;

                if(distance[start] == Long.MIN_VALUE) continue;
                else if (distance[start] == Long.MAX_VALUE) {
                    distance[end] = Long.MAX_VALUE;
                } else if (distance[end] < distance[start] + cityMoney[end] - price) {
                    distance[end] = distance[start] + cityMoney[end] - price;

                    if (i >= N - 1) {
                        distance[end] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if(distance[eCity] == Long.MIN_VALUE) {
            bw.write("gg");
        } else if (distance[eCity] == Long.MAX_VALUE) {
            bw.write("Gee");
        } else {
            bw.write(distance[eCity] + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Edge {
        int start, end, price;

        public Edge(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", price=" + price +
                    '}';
        }
    }
}
