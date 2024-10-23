import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        String[] strings = br.readLine().split(" ");
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        while (end <= N) {
            if (sum >= S) {
                min = Math.min(min, end - start);
                sum -= arr[start++];
            } else {
                sum += arr[end++];
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
