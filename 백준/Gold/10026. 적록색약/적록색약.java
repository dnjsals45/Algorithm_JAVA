import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {1, -1 ,0 , 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] map = new String[N];
        String[] map2 = new String[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map[i] = s;
            map2[i] = s.replace('G', 'R');
        }

        boolean[][] visited = new boolean[map.length][map[0].length()];
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <map[0].length(); j++) {
                if (!visited[i][j]) {
                    count++;
                    solve(map, visited, i, j);
                }
            }
        }

        System.out.print(count);

        count = 0;
        visited = new boolean[map2.length][map2[0].length()];
        for (int i = 0; i < map2.length; i++) {
            for (int j = 0; j < map2[0].length(); j++) {
                if (!visited[i][j]) {
                    count++;
                    solve(map2, visited, i, j);
                }
            }
        }

        System.out.print(" " + count);
    }

    public static void solve(String[] map, boolean[][] visited, int x, int y) {
        char c = map[x].charAt(y);
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length()) {
                    continue;
                }

                if (!visited[nextX][nextY] && map[nextX].charAt(nextY) == c) {
                    visited[nextX][nextY] = true;
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
