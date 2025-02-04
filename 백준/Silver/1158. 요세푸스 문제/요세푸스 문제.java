import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        ArrayList<String> origin = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            origin.add(i + "");
        }

        String[] temp = new String[n];
        int count = 0;
        int idx = k - 1;
        temp[count++] = origin.remove(idx--);
        while (!origin.isEmpty()) {
            idx = (idx + k) % origin.size();
            temp[count++] = origin.remove(idx--);
        }

        String result = String.join(", ", temp);
        System.out.println("<" + result + ">");
    }
}