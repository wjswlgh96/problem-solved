import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MyQueue queue = new MyQueue();

        int n = Integer.parseInt(br.readLine());
        String[] inputs;

        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");

            switch (inputs[0]) {
                case "pop": {
                    bw.write(queue.pop() + "\n");
                    break;
                }
                case "front": {
                    bw.write(queue.front() + "\n");
                    break;
                }
                case "back": {
                    bw.write(queue.back() + "\n");
                    break;
                }
                case "size": {
                    bw.write(queue.size() + "\n");
                    break;
                }
                case "empty": {
                    bw.write(queue.empty() + "\n");
                    break;
                }
                default: {
                    queue.push(Integer.parseInt(inputs[1]));
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class MyQueue {
        private Node front;
        private Node rear;
        private int size;

        public MyQueue() {
            this.front = null;
            this.rear = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(int value) {
            Node newNode = new Node(value);
            if (rear != null) {
                rear.next = newNode;
            }
            rear = newNode;
            if (front == null) {
                front = rear;
            }
            size++;
        }

        public int pop() {
            if (isEmpty()) {
                return - 1;
            }
            int value = front.value;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return value;
        }

        public int size() {
            return size;
        }

        public int empty() {
            return isEmpty() ? 1 : 0;
        }

        public int front() {
            return front == null ? -1 : front.value;
        }

        public int back() {
            return rear == null ? -1 : rear.value;
        }

        @Override
        public String toString() {
            return "MyQueue{" +
                    "front=" + front +
                    ", rear=" + rear +
                    ", size=" + size +
                    '}';
        }

        private class Node {
            int value;
            Node next;

            public Node(int value) {
                this.value = value;
                this.next = null;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "value=" + value +
                        ", next=" + next +
                        '}';
            }
        }
    }
}