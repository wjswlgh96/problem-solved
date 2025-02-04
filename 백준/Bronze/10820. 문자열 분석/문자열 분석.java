import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            int lower = 0;
            int upper = 0;
            int blank = 0;
            int number = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == ' ') {
                    blank++;
                } else if (Character.isDigit(c)) {
                    number++;
                } else if (Character.toLowerCase(c) == c) {
                    lower++;
                } else if (Character.toUpperCase(c) == c) {
                    upper++;
                }
            }

            bw.write(lower + " " + upper + " " + number + " " + blank + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}