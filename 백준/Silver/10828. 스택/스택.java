import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack(N);
        String[] command;
        for (int i = 0; i < N; i++) {
            command = br.readLine().split(" ");
            switch (command[0]) {
                case "top": {
                    bw.write(stack.top() + "\n");
                    break;
                }
                case "size": {
                    bw.write(stack.size() + "\n");
                    break;
                }
                case "empty": {
                    bw.write(stack.empty() + "\n");
                    break;
                }
                case "pop": {
                    bw.write(stack.pop() + "\n");
                    break;
                }
                default: {
                    int value = Integer.parseInt(command[1]);
                    stack.push(value);
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static class MyStack {
        private int size = 0;
        private int top;
        private int[] stack;

        public MyStack(int size) {
            this.size = size;
            this.top = -1;
            this.stack = new int[size];
        }

        public void push(int value) {
            stack[++top] = value;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }

            return stack[top--];
        }

        public int size() {
            return top + 1;
        }

        public int empty() {
            if (isEmpty()) {
                return 1;
            }

            return 0;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int top() {
            if (isEmpty()) {
                return -1;
            }

            return stack[top];
        }
    }
}
