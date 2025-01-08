import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MyDeque deque = new MyDeque();
        int n = Integer.parseInt(br.readLine());
        String[] inputs;
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");

            switch (inputs[0]) {
                case "push_back": {
                    deque.pushBack(Integer.parseInt(inputs[1]));
                    break;
                }
                case "push_front": {
                    deque.pushFront(Integer.parseInt(inputs[1]));
                    break;
                }
                case "pop_front": {
                    bw.write(deque.popFront() + "\n");
                    break;
                }
                case "pop_back": {
                    bw.write(deque.popBack() + "\n");
                    break;
                }
                case "size": {
                    bw.write(deque.size() + "\n");
                    break;
                }
                case "empty": {
                    bw.write(deque.empty() + "\n");
                    break;
                }
                case "front": {
                    bw.write(deque.front() + "\n");
                    break;
                }
                case "back": {
                    bw.write(deque.back() + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class MyDeque {

        private Node head = null;
        private Node tail = null;
        private int size = 0;

        public void pushFront(int value) {
            Node newNode = new Node(value);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }

            size++;
        }

        public void pushBack(int value) {
            Node newNode = new Node(value);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }

        public int popFront() {
            if (isEmpty()) {
                return -1;
            }

            int value = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }

            size--;
            return value;
        }

        public int popBack() {
            if (isEmpty()) {
                return -1;
            }

            int value = tail.value;
            tail = tail.prev;
            if (tail == null) {
                head = null;
            } else {
                tail.next = null;
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
            return isEmpty() ? -1 : head.value;
        }

        public int back() {
            return isEmpty() ? -1 : tail.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private class Node {
            int value;
            Node prev;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }
    }
}
