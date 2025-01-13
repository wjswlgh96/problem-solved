import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String string = Integer.toString(sc.nextInt(), sc.nextInt());
        System.out.println(string.toUpperCase());
    }

}