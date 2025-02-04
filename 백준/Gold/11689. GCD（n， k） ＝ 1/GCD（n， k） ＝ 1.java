import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long result = N;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                result = result - result / i;
                while (N % i == 0) {
                    N /= i;
                }
            }
        }
        
        // 목표 수가 소수일 경우에는 2나 3, 즉 소인수로 나눠지지 않음
        // 때문에 공식을 따로 하나 빼줌
        if (N > 1) {
            result = result - result / N;
        }

        System.out.println(result);
    }
}