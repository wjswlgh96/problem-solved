import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int digit = sc.nextInt();

        int num = 0;
        for (int i = digit - 1; i >= 0; i--) {
            int curr = sc.nextInt();
            int pow = (int) Math.pow(A, i);
            num += (curr * pow);
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            stack.push(num % B);
            num /= B;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());
    }
}