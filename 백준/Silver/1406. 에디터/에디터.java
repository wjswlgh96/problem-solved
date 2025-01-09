import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        ArrayDeque<String> left = new ArrayDeque<>();
        ArrayDeque<String> right = new ArrayDeque<>();
        Collections.addAll(left, str);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputs =  br.readLine().split(" ");

            switch (inputs[0]) {
                case "L": {
                    if (!left.isEmpty()) {
                        right.offerLast(left.pollLast());
                    }
                    break;
                }
                case "D": {
                    if (!right.isEmpty()) {
                        left.offerLast(right.pollLast());
                    }
                    break;
                }
                case "B": {
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                    break;
                }
                case "P": {
                    left.offerLast(inputs[1]);
                    break;
                }
            }
        }

        while (!right.isEmpty()) {
            left.offer(right.pollLast());
        }

        StringBuilder sb = new StringBuilder();

        while (!left.isEmpty()) {
            sb.append(left.pollFirst());
        }

        System.out.println(sb.toString());
    }
}