import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = sc.nextInt();
        int i = 2;
        while (num != 1) {
            if (num % i == 0) {
                bw.write(i + "\n");
                num /= i;
                i = 2;
                continue;
            }
            
            i++;
        }

        bw.flush();
        bw.close();
    }
}