import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[101];

        for (int i = 0; i < board.length; i++) {
            board[i] = i;
        }

        boolean[] visited = new boolean[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            board[start] = end;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int cnt = cur[1];
            if (now == 100) {
                System.out.println(cnt);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next > 100) continue;
                next = board[next];
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
            }
        }
    }

}
