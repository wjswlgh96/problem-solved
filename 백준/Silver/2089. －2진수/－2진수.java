import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        if (num == 0) {
            System.out.println("0");
            return;
        }

        while (num != 0) {
            int remainder = num % -2;
            num /= -2;
            if (remainder < 0) {
                remainder = Math.abs(remainder);
                num++;
            }

            sb.append(remainder);
        }

        System.out.println(sb.reverse().toString());
    }
}