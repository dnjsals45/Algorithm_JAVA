import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    // 0: 빈 칸, 1: 벽, 2: 바이러스
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        map = new int[N][M];

        List<int[]> empty = new ArrayList<>();
        List<int[]> virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 0) empty.add(new int[]{i, j});
                if (map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        visited = new boolean[N][M];

        for (int i = 0; i < empty.size(); i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    map[empty.get(i)[0]][empty.get(i)[1]] = 1;
                    map[empty.get(j)[0]][empty.get(j)[1]] = 1;
                    map[empty.get(k)[0]][empty.get(k)[1]] = 1;
                    answer = Math.max(answer, solution(N, M, virus));
                    map[empty.get(i)[0]][empty.get(i)[1]] = 0;
                    map[empty.get(j)[0]][empty.get(j)[1]] = 0;
                    map[empty.get(k)[0]][empty.get(k)[1]] = 0;
                }
            }
        }

        System.out.println(answer);
    }

    private static int solution(int N, int M, List<int[]> virus) {
        Queue<int[]> q = new LinkedList<>();

        for (int[] v : virus) {
            q.add(v);
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 0) cnt++;
                visited[i][j] = false;
            }
        }

        return cnt;
    }
}
