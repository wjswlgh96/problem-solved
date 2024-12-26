import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while(!(line = br.readLine()).equals("0 0")) {
            String[] parts = line.split(" ");

            int A = Integer.parseInt(parts[0]);
            int B = Integer.parseInt(parts[1]);

            bw.write(String.valueOf(A + B) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}