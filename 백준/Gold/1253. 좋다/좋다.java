import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];
        String[] strArray = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(strArray[i]);
        }

        Arrays.sort(nums);

        int count = 0;
        for(int k = 0; k < N; k++) {
            int i = 0;
            int j = N - 1;
            long target = nums[k];

            while(i < j) {
                if(nums[i] + nums[j] == target) {
                    if(i != k && j != k) {
                        count++;
                        break;
                    } else if(i == k) {
                        i++;
                    } else if(j == k) {
                        j--;
                    }
                } else if(nums[i] + nums[j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        System.out.println(count);
    }
}
