import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = bf.readLine();

        for (int i = 0; i < str.length(); i += 10) {
            int last = Math.min((i + 10), str.length());
            bw.write(str.substring(i, last) + "\n");
        }

        bw.flush();
    }
}