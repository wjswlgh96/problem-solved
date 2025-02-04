import java.io.*;
import java.util.*;

public class Main {

    static int[] person;
    static int[] truePerson;
    static List<Integer>[] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        if (p == 0) {
            System.out.println(m);
            return;
        }
        truePerson = new int[p];
        person = new int[n + 1];
        party = new ArrayList[m];
        for (int i = 1; i <= n; i++) {
            person[i] = i;
        }

        for (int i = 0; i < p; i++) {
            int idx = Integer.parseInt(st.nextToken());
            truePerson[i] = idx;
        }

        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int num = Integer.parseInt(st.nextToken());
                party[i].add(num);
            }
        }

        for (int i = 0; i < m; i++) {
            int a = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(a, party[i].get(j));
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            int firstPeople = party[i].get(0);

            boolean isFind = true;
            for (int j = 0; j < truePerson.length; j++) {
                if (isSame(firstPeople, truePerson[j])) {
                    isFind = false;
                    break;
                }
            }

            if (isFind) count++;
        }

        System.out.println(count);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            person[b] = a;
        }
    }

    private static int find(int a) {
        if (a == person[a]) {
            return a;
        }

        return person[a] = find(person[a]);
    }

    private static boolean isSame(int a, int b) {
        if (find(a) == find(b)) {
            return true;
        }

        return false;
    }
}
