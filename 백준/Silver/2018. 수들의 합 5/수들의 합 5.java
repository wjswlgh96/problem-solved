import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 1;

        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;

        while(endIndex != N) {
            if(sum == N) {
                sum += ++endIndex;
                count++;
            } else if(N > sum) {
                sum += ++endIndex;
            } else if(N < sum) {
                sum -= startIndex++;
            }
        }

        System.out.println(count);
    }
}