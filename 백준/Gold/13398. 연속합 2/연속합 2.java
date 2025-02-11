import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        right[n - 1] = arr[n - 1];

        int max = left[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i], left[i - 1] + arr[i]);
            max = Math.max(max, left[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1] + arr[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, left[i - 1] + right[i + 1]);
        }

        bw.write(max + "");
        bw.close();
        br.close();
    }

}
