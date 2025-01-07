import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> stack = new ArrayDeque<>();
        char[] brackets = br.readLine().toCharArray();
        stack.push(brackets[0]);
        int count = 0;
        for (int i = 1; i < brackets.length; i++) {
            if (brackets[i] == '(') {
                stack.push(brackets[i]);
            } else {
                stack.pop();
                if (brackets[i - 1] == '(') {
                    count += stack.size();
                } else {
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }
}