import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        BigInteger n = new BigInteger(str, 2);
        System.out.println(n.toString(8));
    }
}
