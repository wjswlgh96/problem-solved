import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strArr = new String[3];
        for (int i = 0; i < 3; i++) {
            strArr[i] = br.readLine();
        }

        int searchIdx = 0;
        for (int i = 0; i < 3; i++) {
            if (strArr[i].matches("\\d+")) {
                searchIdx = i;
            }
        }

        int n = 3 - searchIdx;
        int target = Integer.parseInt(strArr[searchIdx]);
        for (int i = 0; i < n; i++) {
            target++;
        }

        if (target % 3 == 0 && target % 5 == 0) {
            bw.write("FizzBuzz");
        } else if (target % 3 == 0 && target % 5 != 0) {
            bw.write("Fizz");
        } else if (target % 3 != 0 && target % 5 == 0) {
            bw.write("Buzz");
        } else {
            bw.write(String.valueOf(target));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}