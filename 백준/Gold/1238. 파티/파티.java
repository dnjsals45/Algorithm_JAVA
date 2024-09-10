import java.util.*;
import java.io.*;

// 최소 비용 -> 다익스트라 알고리즘
public class Main {
    static class Node implements Comparable<Node>{
        int end;
        int time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] list = new ArrayList[N + 1];
        List<Node>[] reverseList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        int[] dist1 = new int[N + 1];
        int[] dist2 = new int[N + 1];

        PriorityQueue<Node> pq1 = new PriorityQueue<>();
        PriorityQueue<Node> pq2 = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            dist1[i] = Integer.MAX_VALUE;
            dist2[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st= new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, time));
            reverseList[end].add(new Node(start, time));
        }

        dijkstra(X, list, dist1, pq1);
        dijkstra(X, reverseList, dist2, pq2);

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dist1[i] + dist2[i]);
        }

        System.out.println(result);
    }

    public static void dijkstra(int start, List<Node>[] list, int[] dist, PriorityQueue<Node> pq) {
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int end = current.end;
            int time = current.time;

            if (dist[end] < time) {
                continue;
            }

            for (Node node : list[end]) {
                if (dist[end] + node.time < dist[node.end]) {
                    dist[node.end] = dist[end] + node.time;
                    pq.offer(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}