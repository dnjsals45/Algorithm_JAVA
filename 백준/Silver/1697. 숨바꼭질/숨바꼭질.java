import java.io.*;
import java.util.*;

public class Main {
    static int now, target;
    static int[] position;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        now = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        position = new int[100001];
        position[now] = 1;

        queue.add(now);

        System.out.println(bfs());
    }

    public static int bfs() {
        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now == target) {
                return position[now] - 1;
            }
            if (now - 1 >= 0 && position[now - 1] == 0) {
                position[now - 1] = position[now] + 1;
                queue.add(now - 1);
            }
            if (now + 1 <= 100000 && position[now + 1] == 0) {
                position[now + 1] = position[now] + 1;
                queue.add(now + 1);
            }
            if (now * 2 <= 100000 && position[now * 2] == 0) {
                position[now * 2] = position[now] + 1;
                queue.add(now * 2);
            }
        }
        return -1;
    }
}