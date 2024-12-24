import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        long result = 0;

        String[] numbers = br.readLine().split(" ");
        long[] sumArr = new long[n];
        long[] C = new long[m];
        sumArr[0] = Integer.parseInt(numbers[0]);
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(numbers[i]);
        }

        for(int i = 0; i < n; i++) {
            int remainder = (int) (sumArr[i] % m);
            if(remainder == 0) {
                result++;
            }

            C[remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if(C[i] > 1) {
                result = result + (C[i] * (C[i] - 1) / 2);
            }
        }

        System.out.println(result);
    }
}