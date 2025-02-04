import java.io.*;
import java.util.*;

public class Main {

    static int[] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        city = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            city[i] = i;
        }

        String[] nodes;
        for (int i = 0; i < n; i++) {
            nodes = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                if (nodes[j].equals("1")) {
                    union(i + 1, j + 1);
                }
            }
        }

        String[] routes = br.readLine().split(" ");
        int node = find(Integer.parseInt(routes[0]));
        for (int i = 1; i < m; i++) {
            if (node != find(Integer.parseInt(routes[i]))) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            city[b] = a;
        }
    }

    private static int find(int b) {
        if (b == city[b]) {
            return b;
        }

        return city[b] = find(city[b]);
    }

}
