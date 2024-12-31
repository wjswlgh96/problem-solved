import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    public static void quickSort(int[] A, int start, int end, int K) {
        if (start < end) {
            int pivot = partition(A, start, end);
            if (pivot == K) {
                return;
            } else if (K < pivot) {
                quickSort(A, start, pivot - 1, K);
            } else {
                quickSort(A, pivot + 1, end, K);
            }
        }
    }

    public static int partition(int[] A, int start, int end) {
        if(start + 1 == end) {
            if(A[start] > A[end]) {
                swap(A, start, end);
                return end;
            }
        }

        int middle = (start + end) / 2;
        swap(A, start, middle);
        int pivot = A[start];
        int i = start + 1;
        int j = end;

        while(i <= j) {
            while(i <= end && A[i] < pivot) {
                i++;
            }
            while(j >= start + 1 && A[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(A, i++, j--);
            }
        }

        A[start] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}