import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] dates = br.readLine().split(" ");
        int M = Integer.parseInt(dates[0]);
        int D = Integer.parseInt(dates[1]);

        LocalDate ld = LocalDate.of(2007, M, D);
        bw.write(ld.getDayOfWeek().toString().substring(0, 3));

        bw.flush();
        bw.close();
        br.close();
    }
}