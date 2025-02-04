import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(str[i]);
            if(max < num) {
                max = num;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(str[i]);
            sum +=  ((double) num / max) * 100;
        }

        double average = (double) sum / n;
        System.out.println(average);
    }
}