import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        int left = 0;
        int right = n - 1;
        long min = Long.MAX_VALUE;
        long result1 = 0;
        long result2 = 0;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                result1 = arr[left];
                result2 = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(sb.append(result1).append(" ").append(result2));
    }

}
