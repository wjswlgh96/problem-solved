import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        int[] arr = new int[26];
        for (char c : input) {
            arr[(int) c % 97]++;
        }

        for (int i : arr) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}