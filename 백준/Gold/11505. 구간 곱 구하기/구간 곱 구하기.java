import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] tree;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int height = N;
        int treeHeight = 0;
        while (height != 0) {
            height /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new long[treeSize];
        Arrays.fill(tree, 1);
        int startIndex = treeSize / 2;
        for (int i = startIndex; i < startIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(startIndex - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            long end = Long.parseLong(st.nextToken());

            if (command == 1) {
                updateValue(end, start + (startIndex - 1));
            } else {
                getMul(start + startIndex - 1, (int) end + startIndex - 1);
            }
        }

        bw.flush();
        br.close();
    }

    static void setTree(int index) {
        for (int i = index; i >= 1; i--) {
            tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % MOD;
        }
    }

    static void updateValue(long value, int index) {
        tree[index] = value;
        while (index > 1) {
            index /= 2;
            tree[index] = (tree[index * 2] * tree[index * 2 + 1]) % MOD;
        }
    }

    static void getMul(int start, int end) throws IOException {
        long result = 1;
        while (start <= end) {
            if (start % 2 == 1) {
                result = result * tree[start] % MOD;
                start++;
            }

            if (end % 2 == 0) {
                result = result * tree[end] % MOD;
                end--;
            }

            start /= 2;
            end /= 2;
        }

        bw.write(result + "\n");
    }
}
