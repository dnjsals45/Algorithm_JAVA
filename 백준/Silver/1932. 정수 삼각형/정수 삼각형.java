import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] Triangle;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Triangle = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                Triangle[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        for(int i = 0; i < N; i++) {
            dp[N - 1][i] = Triangle[N - 1][i];
        }

        System.out.println(solve(0, 0));
    }

    static int solve(int depth, int index) {
        if (depth == N - 1)
            return dp[N - 1][index];

        if (dp[depth][index] == -1) {
            dp[depth][index] = Math.max(solve(depth + 1, index), solve(depth + 1, index + 1)) + Triangle[depth][index];
        }

        return dp[depth][index];
    }
}