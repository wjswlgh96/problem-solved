import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int command = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (command == 0) {
                union(a, b);
            } else {
                if (isSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
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
        }
        return parent[b] = find(parent[b]);
    }

    private static boolean isSame(int a, int b) {
        if (find(a) == find(b)) {
            return true;
        }

        return false;
    }
}
