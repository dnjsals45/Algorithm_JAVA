import java.io.*;
import java.util.*;

public class Main {
    static int row, col;
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new int[row][col];

        for (int i = 0; i < row; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    queue.add(new int[]{i, j});
            }
        }
        System.out.println(bfs());
    }


    public static int bfs() {
        int max = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 4; ++i) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < row && nextY < col) {
                    if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = map[nowX][nowY] + 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (map[i][j] == 0)
                    return -1;
                if (max < map[i][j])
                    max = map[i][j];
            }
        }
        return max - 1;
    }
}