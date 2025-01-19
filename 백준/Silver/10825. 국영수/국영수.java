import java.io.*;
import java.util.*;

public class Main {

    static String[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new String[N][4];

        for (int i = 0; i < N; i++) {
            A[i] = br.readLine().split(" ");
        }
        mergeSort(0, N - 1);
        for (int i = 0; i < N; i++) {
            bw.write(A[i][0] + "\n");
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
        String[][] temp = new String[right - left + 1][4];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            String name1 = A[i][0];
            String name2 = A[j][0];

            int kor1 = Integer.parseInt(A[i][1]);
            int kor2 = Integer.parseInt(A[j][1]);

            int en1 = Integer.parseInt(A[i][2]);
            int en2 = Integer.parseInt(A[j][2]);

            int math1 = Integer.parseInt(A[i][3]);
            int math2 = Integer.parseInt(A[j][3]);

            if (kor1 != kor2) {
                if (kor1 > kor2) {
                    temp[k++] = A[i++];
                } else {
                    temp[k++] = A[j++];
                }
            } else if (en1 != en2) {
                if (en1 < en2) {
                    temp[k++] = A[i++];
                } else {
                    temp[k++] = A[j++];
                }
            } else if (math1 != math2) {
                if (math1 > math2) {
                    temp[k++] = A[i++];
                } else {
                    temp[k++] = A[j++];
                }
            } else {
                if (name1.compareTo(name2) < 0) {
                    temp[k++] = A[i++];
                } else {
                    temp[k++] = A[j++];
                }
            }
        }

        while (i <= mid) {
            temp[k++] = A[i++];
        }

        while (j <= right) {
            temp[k++] = A[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            A[left + l] = temp[l];
        }
    }
}
