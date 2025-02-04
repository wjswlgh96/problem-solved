import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int answerLength = Integer.parseInt(firstLine[1]);

        int[][] numbers = new int[n + 1][n + 1];
        int[][] sumArr = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            String[] lineNumbers = br.readLine().split(" ");
            for(int j = 1; j <= n; j++) {
                numbers[i][j] = Integer.parseInt(lineNumbers[j - 1]);
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sumArr[i][j] = sumArr[i][j - 1] + sumArr[i - 1][j] - sumArr[i - 1][j - 1] + numbers[i][j];
            }
        }

        for (int i = 0; i < answerLength; i++) {
            String[] answerStr = br.readLine().split(" ");
            int x1 = Integer.parseInt(answerStr[0]);
            int y1 = Integer.parseInt(answerStr[1]);
            int x2 = Integer.parseInt(answerStr[2]);
            int y2 = Integer.parseInt(answerStr[3]);

            System.out.println(sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1]);
        }
    }
}