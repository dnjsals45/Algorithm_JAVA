import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int sharkX, sharkY;
    static boolean[][] visited;
    static int level = 2, eat = 0, time = 0, N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Node target = bfs();

            if (target == null) break;

            sharkX = target.x;
            sharkY = target.y;
            time += target.dist;
            eat++;

            if (eat == level) {
                level++;
                eat = 0;
            }

            map[sharkX][sharkY] = 0;
        }

        System.out.println(time);
    }

    private static Node bfs() {
        visited = new boolean[N][N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                if (map[nx][ny] > level) continue;

                visited[nx][ny] = true;
                if (map[nx][ny] < level && map[nx][ny] != 0) {
                    pq.add(new Node(nx, ny, cur.dist + 1));
                }
                q.add(new Node(nx, ny, cur.dist + 1));
            }
        }

        if (pq.isEmpty()) return null;
        return pq.poll();
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int dist;

        public Node (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.dist - o.dist;
        }
    }
}
