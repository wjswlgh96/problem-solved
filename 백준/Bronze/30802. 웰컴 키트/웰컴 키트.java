import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        String[] bundleStr = br.readLine().split(" ");
        int[] shirts = new int[6];
        int[] bundle = new int[2];
        for (int i = 0; i < shirts.length; i++) {
            shirts[i] = Integer.parseInt(strArr[i]);
        }
        for (int i = 0; i < bundle.length; i++) {
            bundle[i] = Integer.parseInt(bundleStr[i]);
        }

        int shirtBundle = bundle[0];
        int penBundle = bundle[1];

        int shirtCount = 0;
        int penCount = 0;
        penCount += (int) Math.floor((n * 1.0) / penBundle);
        for (int shirt : shirts) {
            if (shirt != 0 && shirt <= shirtBundle) {
                shirtCount++;
            } else {
                shirtCount += (int) Math.ceil((shirt * 1.0) / shirtBundle);
            }
        }

        bw.write(shirtCount + "\n");
        bw.write(penCount + " " + (n % penBundle));

        bw.flush();
        bw.close();
        br.close();
    }
}
