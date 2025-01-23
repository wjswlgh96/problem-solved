import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int start = 1;
        int end = A[n - 1] - A[0];
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1;
            int last = A[0];

            for (int i = 1; i < n; i++) {
                if (A[i] - last >= mid) {
                    count++;
                    last = A[i];
                }
            }

            if (count >= c) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
