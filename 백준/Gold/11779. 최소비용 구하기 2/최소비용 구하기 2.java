import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");

            int startInput = Integer.parseInt(s[0]);
            int endInput = Integer.parseInt(s[1]);
            int costInput = Integer.parseInt(s[2]);

            graph.get(startInput).add(new Node(endInput, costInput));
        }

        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);

        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dijkstra(graph, start, dist, path);

        Stack<Integer> stack = new Stack<>();
        int current = end;
        while (current != 0) {
            stack.push(current);
            current = path[current];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n");
        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    public static void dijkstra(List<List<Node>> graph, int start, int[] dist, int[] path) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.end] < cur.cost)
                continue;

            for (Node next : graph.get(cur.end)) {
                if (dist[next.end] > dist[cur.end] + next.cost) {
                    dist[next.end] = dist[cur.end] + next.cost;
                    path[next.end] = cur.end;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
    }
}
