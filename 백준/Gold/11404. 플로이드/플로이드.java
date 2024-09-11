import java.util.*;
import java.io.*;

// 다익스트라 -> 플로이드-와샬 알고리즘으로 변경
public class Main {

    static int INF = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시의 개수 n
        int n = Integer.parseInt(br.readLine());

        // 버스의 개수 m
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = i == j ? 0 : INF;
            }
        }

        for (int i = 1; i <= m; i++) {
            // 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (arr[a][b] > c) {
                arr[a][b] = c;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][k] + arr[k][j] < arr[i][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] == INF ? 0 + " " : arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
