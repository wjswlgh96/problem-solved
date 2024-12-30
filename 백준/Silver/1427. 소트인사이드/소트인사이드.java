import java.io.*;

public class Main {

    // 선택 정렬로 풀어보기 내림차순이기에 최댓값으로 비교
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split("");
        int[] numbers = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            numbers[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;

            for (int j = i; j < numbers.length; j++) {
                if (max < numbers[j]) {
                    max = numbers[j];
                    maxIndex = j;
                }
            }

            int temp = numbers[i];
            numbers[i] = max;
            numbers[maxIndex] = temp;
        }

        for (int i = 0; i < numbers.length; i++) {
            bw.write(String.valueOf(numbers[i]));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}