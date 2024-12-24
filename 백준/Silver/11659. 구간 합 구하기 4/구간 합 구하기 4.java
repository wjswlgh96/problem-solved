import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int answer = Integer.parseInt(firstLine[1]);

        String[] numbers = br.readLine().split(" ");
        int[] sumArr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(numbers[i - 1]);
            sumArr[i] = sumArr[i - 1] + num;
        }

        for (int q = 0; q < answer; q++) {
            String[] str = br.readLine().split(" ");
            int i = Integer.parseInt(str[0]);
            int j = Integer.parseInt(str[1]);

            System.out.println(sumArr[j] - sumArr[i - 1]);
        }

    }
}