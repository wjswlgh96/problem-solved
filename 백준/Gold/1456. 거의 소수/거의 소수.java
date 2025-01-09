import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        long[] numbers = new long[10000001];
        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = i;
        }

        for (int i = 0; i <= Math.sqrt(numbers.length); i++) {
            if (numbers[i] == 0) {
                continue;
            }

            for (int j = i + i; j < numbers.length; j = j + i) {
                numbers[j] = 0;
            }
        }

        Set<Long> set = new HashSet<>();
        for (int i = 2; i <= Math.sqrt(B); i++) {
            if (numbers[i] != 0) {
                long value = numbers[i];

                while (value <= B / numbers[i]) {
                    value *= numbers[i];
                    if(value >= A && value <= B) {
                        set.add(value);
                    }
                }
            }
        }

        System.out.println(set.size());
    }
}
