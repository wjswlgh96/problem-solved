import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        MyData[] numbers = new MyData[n];

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            numbers[i] = new MyData(value, i);
        }

        Arrays.sort(numbers);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < numbers[i].index - i) {
                max = numbers[i].index - i;
            }
        }

        bw.write(String.valueOf(max + 1));
        bw.flush();
        bw.close();
        br.close();
    }
}

class MyData implements Comparable<MyData> {
    int value;
    int index;

    public MyData(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(MyData o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "value=" + value +
                ", index=" + index +
                '}';
    }
}