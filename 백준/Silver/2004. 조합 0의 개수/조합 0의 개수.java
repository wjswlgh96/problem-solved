import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        // n, m 의 조합 구하기
        long countTwo = countFactor(n, 2) - countFactor(m, 2) - countFactor(n - m, 2);
        long countFive = countFactor(n, 5) - countFactor(m, 5) - countFactor(n - m, 5);

        System.out.println(Math.min(countTwo, countFive));
    }

    private static long countFactor(long num, int p) {
        long count = 0;
        while (num >= p) {
            count += num / p;
            num /= p;
        }

        return count;
    }
}