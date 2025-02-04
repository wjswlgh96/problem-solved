import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] sumArr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(arr);

        sumArr[0] = arr[0];

        for(int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += sumArr[i];
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}