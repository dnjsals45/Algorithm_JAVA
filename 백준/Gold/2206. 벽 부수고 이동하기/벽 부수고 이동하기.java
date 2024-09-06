import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.print(bfs());
    }

    static int bfs() {
        queue.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int step = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int broken = cur[2];

                if (x == N - 1 && y == M - 1) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }

                    if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                        queue.add(new int[]{nx, ny, broken});
                        visited[nx][ny][broken] = true;
                    }

                    if (map[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new int[]{nx, ny, 1});
                    }
                }
            }
            step++;
        }

        return -1;
    }
}