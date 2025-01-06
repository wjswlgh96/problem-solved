import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] charArr = br.readLine().toCharArray();

            for (int j = 0; j < charArr.length; j++) {
                if (charArr[j] == '(') {
                    stack.push(charArr[j]);
                } else {
                    if (stack.isEmpty()) {
                        stack.push(charArr[j]);
                        break;
                    }

                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(charArr[j]);
                    }
                }
            }

            if(stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
            stack.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
