import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long start = 1;
        long end = k;
        long result = 0;

        while (start <= end) {
            long middle = (start + end) / 2;
            long count = 0;

            for (int i = 1; i <= n; i++) {
                count += Math.min(middle / i, n);
            }

            if (count < k) {
                start = middle + 1;
            } else {
                result = middle;
                end = middle - 1;
            }
        }

        System.out.println(result);
    }
}
