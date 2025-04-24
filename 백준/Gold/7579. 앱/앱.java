import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] mem = new int[N];
        int[] cost = new int[N];

        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            mem[i] = Integer.parseInt(s1[i]);
            cost[i] = Integer.parseInt(s2[i]);
        }

        int[] dp = new int[10001];

        for (int i = 0; i < N; i++) {
            for (int j = 10000; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + mem[i]);
            }
        }

        for (int i = 0; i <= 10000; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}
