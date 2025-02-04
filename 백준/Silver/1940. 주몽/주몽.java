import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] items = new int[N];
        String[] strItems = br.readLine().split(" ");
        for (int i = 0; i < items.length; i++) {
            items[i] = Integer.parseInt(strItems[i]);
        }

        int count = 0;
        int startIndex = 0;
        int endIndex = items.length - 1;

        Arrays.sort(items);

        while(startIndex < endIndex) {
            int i = items[startIndex];
            int j = items[endIndex];
            int sum = i + j;

            if(M == sum) {
                count++;
                startIndex++;
                endIndex--;
            } else if(M > sum) {
                startIndex++;
            } else if(M < sum) {
                endIndex--;
            }
        }

        System.out.println(count);
    }
}