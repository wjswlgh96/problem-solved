import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        int f = 0;
        int s = 0;
        int sum = 0;
        while (pq.size() != 1) {
            f = pq.poll();
            s = pq.poll();

            sum += (f + s);
            pq.offer(f + s);
        }

        System.out.println(sum);
    }
}