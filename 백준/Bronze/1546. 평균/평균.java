import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] scores = new double[n];
        double[] new_scores = new double[n];

        String[] tmp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(tmp[i]);
        }

        Arrays.sort(scores);

        double max = scores[n - 1];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            new_scores[i] = scores[i] / max * 100L;
            sum += new_scores[i];
        }

        System.out.println(sum / n);
    }
}