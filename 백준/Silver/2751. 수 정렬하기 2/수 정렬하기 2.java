import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, n - 1);
        for (int i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void mergeSort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = start + (end - start) / 2;

        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);

        int[] temp = new int[end - start + 1];

        int leftIdx = start;
        int rightIdx = middle + 1;
        int tempIdx = 0;

        while (leftIdx <= middle && rightIdx <= end) {
            if (arr[leftIdx] <= arr[rightIdx]) {
                temp[tempIdx++] = arr[leftIdx++];
            } else {
                temp[tempIdx++] = arr[rightIdx++];
            }
        }

        while (leftIdx <= middle) {
            temp[tempIdx++] = arr[leftIdx++];
        }

        while (rightIdx <= end) {
            temp[tempIdx++] = arr[rightIdx++];
        }

        System.arraycopy(temp, 0, arr, start, temp.length);
    }
}