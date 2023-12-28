import java.io.*;
import java.lang.*;

public class Main {
    static int[] arr;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        solve(0);
        System.out.println(count);
    }

    static void solve(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (promising(depth)) {
                solve(depth + 1);
            }
        }
    }

    static boolean promising(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i])
                return false;
            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }

}