import java.io.*;
import java.util.*;

public class Main {
    static int N, result, row, col;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            map = new int[row][col];
            visited = new boolean[row][col];
            result = 0;

            for (int j = 0; j < count; ++j) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int k = 0; k < row; ++k) {
                for (int l = 0; l < col; ++l) {
                    if (map[k][l] == 1 && !visited[k][l]) {
                        dfs(k, l);
                        result++;
                    }
                }
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; ++i) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < row && nextY < col) {
                if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}