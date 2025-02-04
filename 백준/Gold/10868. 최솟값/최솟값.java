import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int height = N;
        int treeHeight = 0;
        while (height != 0) {
            height /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new int[treeSize];
        Arrays.fill(tree, Integer.MAX_VALUE);
        int startIndex = treeSize / 2;
        for (int i = startIndex; i < startIndex + N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        setTree(startIndex - 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            getMin(s + startIndex - 1, e + startIndex - 1);
        }

        bw.flush();
        br.close();
    }

    static void setTree(int index) {
        for (int i = index; i >= 1; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    static void getMin(int start, int end) throws IOException {
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                min = Math.min(min, tree[start]);
                start++;
            }
            if (end % 2 == 0) {
                min = Math.min(min, tree[end]);
                end--;
            }

            start = start / 2;
            end = end / 2;
        }

        bw.write(min + "\n");
    }
}
