import java.io.*;
import java.util.*;

public class Main {

    static String[][] datas;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        datas = new String[N][2];
        for (int i = 0; i < N; i++) {
            datas[i] = br.readLine().split(" ");
        }

        mergeSort(0, N - 1);
        for (int i = 0; i < N; i++) {
            bw.write(String.join(" ", datas[i]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(left, mid);
            mergeSort(mid + 1, right);

            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right) {
        String[][] temp = new String[right - left + 1][2];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            int age1 = Integer.parseInt(datas[i][0]);
            int age2 = Integer.parseInt(datas[j][0]);

            if (age1 <= age2) {
                temp[k++] = datas[i++];
            } else {
                temp[k++] = datas[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = datas[i++];
        }

        while (j <= right) {
            temp[k++] = datas[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            datas[left + l] = temp[l];
        }
    }
}
