import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();
        int[][] dp = new int[firstArr.length + 1][secondArr.length + 1];

        for (int i = 1; i <= firstArr.length; i++) {
            for (int j = 1; j <= secondArr.length; j++) {
                if (firstArr[i - 1] == secondArr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[firstArr.length][secondArr.length]);
    }
}
