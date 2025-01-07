import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        String front = numbers[0] + numbers[1];
        String end = numbers[2] + numbers[3];

        System.out.println(Long.parseLong(front) + Long.parseLong(end));
        br.close();
    }
}