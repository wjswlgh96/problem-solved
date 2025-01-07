import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArr) {
            if(c == ' ') {
                sb.append(' ');
                continue;
            } else if(Character.isDigit(c)) {
                sb.append(c);
                continue;
            };

            int value = (int) c;
            if (value <= 'Z') {
                value = ((value + 13) > 'Z') ? (value - 26 + 13) : (value + 13);
            } else {
                value = ((value + 13) > 'z') ? (value - 26 + 13) : (value + 13);
            }

            sb.append((char) value);
        }

        System.out.println(sb.toString());
        br.close();
    }
}