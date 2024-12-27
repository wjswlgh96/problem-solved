import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        int[] numbers = new int[N];

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        boolean result = true;
        int index = 1;
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if(num >= index) {
                while(num >= index) {
                    stack.push(index++);
                    sb.append("+\n");
                }

                stack.pop();
                sb.append("-\n");
            } else {
                int peek = stack.pop();

                if(peek > num) {
                    result = false;
                    System.out.println("NO");
                    break;

                } else {
                    sb.append("-\n");
                }
            }
        }

        if(result) {
            System.out.println(sb.toString());
        }
    }
}