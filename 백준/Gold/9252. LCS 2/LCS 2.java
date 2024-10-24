import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String first = br.readLine();
        String second = br.readLine();

        int[][] arr = new int[first.length() + 1][second.length() + 1];

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        int i = first.length();
        int j = second.length();
        while (i > 0 && j > 0) {
            if (arr[i][j] == arr[i - 1][j]) {
                i--;
            } else if (arr[i][j] == arr[i][j - 1]) {
                j--;
            } else {
                sb.append(first.charAt(i - 1));
                i--;
                j--;
            }
        }

        System.out.println(arr[first.length()][second.length()]);
        System.out.println(sb.reverse());
    }
}
