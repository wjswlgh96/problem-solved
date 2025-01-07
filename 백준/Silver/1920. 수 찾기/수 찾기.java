import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] datas = new int[n];
        String[] strDatas = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            datas[i] = Integer.parseInt(strDatas[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] findDatas = new int[m];
        String[] strFinds = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            findDatas[i] = Integer.parseInt(strFinds[i]);
        }

        // 이진 탐색을 위한 정렬
        Arrays.sort(datas);

        for (int i = 0; i < m; i++) {
            boolean isFind = false;
            int target = findDatas[i];
            int start = 0;
            int end = n - 1;

            while (start <= end) {
                int middle = (start + end) / 2;
                int midValue = datas[middle];

                if (midValue > target) {
                    end = middle - 1;
                } else if (midValue < target) {
                    start = middle + 1;
                } else {
                    isFind = true;
                    break;
                }
            }

            if(isFind) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}