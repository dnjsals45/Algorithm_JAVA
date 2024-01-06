import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][3];

        // Map 생성
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N; i++) {
            map[i][0] += Math.min(map[i - 1][1], map[i - 1][2]);
            map[i][1] += Math.min(map[i - 1][0], map[i - 1][2]);
            map[i][2] += Math.min(map[i - 1][0], map[i - 1][1]);
        }

        int min = Math.min(map[N - 1][0], map[N - 1][1]);
        System.out.println(Math.min(min, map[N- 1][2]));

    }
}