import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] tree = new int[26][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int node = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[node][0] = (left == '.') ? -1 : left - 'A';
            tree[node][1] = (right == '.') ? -1 : right - 'A';
        }

        preOrder(0);
        bw.write("\n");
        inOrder(0);
        bw.write("\n");
        postOrder(0);

        bw.flush();
        br.close();
    }

    private static void preOrder(int now) throws IOException {
        if (now == -1) {
            return;
        }

        bw.write((char)(now + 'A'));
        preOrder(tree[now][0]);
        preOrder(tree[now][1]);
    }

    private static void inOrder(int now) throws IOException {
        if (now == -1) {
            return;
        }

        inOrder(tree[now][0]);
        bw.write((char)(now + 'A'));
        inOrder(tree[now][1]);
    }

    private static void postOrder(int now) throws IOException {
        if (now == -1) {
            return;
        }

        postOrder(tree[now][0]);
        postOrder(tree[now][1]);
        bw.write((char)(now + 'A'));
    }


}
