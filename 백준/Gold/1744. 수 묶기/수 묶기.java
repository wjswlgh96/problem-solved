import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 양수 큐, 음수 큐, 1, 0 을 따로 나눔
        PriorityQueue<Integer> plusPq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int oneCnt = 0;
        int zeroCnt = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                zeroCnt++;
            } else if (num == 1) {
                oneCnt++;
            } else if (num < 0) {
                minusPq.add(num);
            } else {
                plusPq.add(num);
            }
        }

        int sum = 0;
        while (!plusPq.isEmpty()) {
            if (plusPq.size() >= 2) {
                sum += (plusPq.poll() * plusPq.poll());
            } else {
                sum += plusPq.poll();
            }
        }

        while (!minusPq.isEmpty()) {
            if (minusPq.size() >= 2) {
                sum += (minusPq.poll() * minusPq.poll());
            } else {
                sum += zeroCnt > 0 ? (minusPq.poll() * 0) : minusPq.poll();
                zeroCnt--;
            }
        }

        sum += oneCnt;
        System.out.println(sum);
    }
}