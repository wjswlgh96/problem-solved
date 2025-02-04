import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int height = N;
        while (height != 0) {
            height /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2.0, treeHeight + 1);
        tree = new long[treeSize];
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
                updateTree(end, start + (startIndex - 1));
            } else {
                getSum(start + (startIndex - 1), (int) end + (startIndex - 1));
            }
        }

        bw.flush();
        br.close();
    }

    static void setTree(int index) {
        for (int i = index; i >= 1; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static void updateTree(long value, int index) {
        long updateValue = (long) value - tree[index];
        while (index > 1) {
            tree[index] += updateValue;
            index  /= 2;
        }
    }

    static void getSum(int start, int end) throws IOException {
        long sum = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                sum += tree[start];
            }
            if (end % 2 == 0) {
                sum += tree[end];
            }

            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }

        bw.write(sum + "\n");
    }
}
