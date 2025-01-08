import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split("-");

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].contains("+")) {
                String[] plus = numbers[i].split("[+]");
                int sum = 0;
                for (int j = 0; j < plus.length; j++) {
                    sum += Integer.parseInt(plus[j]);
                }
                numbers[i] = String.valueOf(sum);
            }
        }

        int sum = Integer.parseInt(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            sum -= Integer.parseInt(numbers[i]);
        }

        System.out.println(sum);
    }
}