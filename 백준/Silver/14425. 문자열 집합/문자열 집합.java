import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Node root = new Node();
        while (n > 0) {
            String text = sc.next();
            Node now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new Node();
                }

                now = now.next[c - 'a'];
                if (i == text.length() - 1) {
                    now.isEnd = true;
                }
            }

            n--;
        }

        int count = 0;
        while (m > 0) {
            String text = sc.next();
            Node now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    break;
                }

                now = now.next[c - 'a'];
                if (i == text.length() - 1 && now.isEnd) {
                    count++;
                }
            }

            m--;
        }

        System.out.println(count);
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isEnd;

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + Arrays.toString(next) +
                    ", isEnd=" + isEnd +
                    '}';
        }
    }
}
