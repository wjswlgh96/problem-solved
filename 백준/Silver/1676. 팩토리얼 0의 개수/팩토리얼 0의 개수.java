import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigDecimal bd = new BigDecimal(1);
        for (int i = 1; i <= n; i++) {
            bd = bd.multiply(BigDecimal.valueOf(i));
        }

        String str = bd.toString();
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
