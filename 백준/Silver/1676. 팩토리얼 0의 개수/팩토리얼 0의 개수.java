import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        for(int i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        
        System.out.println(count);
    }
}
