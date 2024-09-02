import java.util.*;
import java.io.*;

public class Main {
    static int V, E, K;
    static int[] dijkstra;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int n;
        int cost;

        Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 정점의 개수 V와 간선의 개수 E
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 시작 정점의 번호 K
        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        dijkstra = new int[V + 1];
        visited = new boolean[V + 1];

        solve(K);

        for (int i = 1; i < V + 1; i++) {
            if (dijkstra[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dijkstra[i] + "\n");
            }
        }

        System.out.print(sb);
    }

    static void solve(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dijkstra, Integer.MAX_VALUE);

        dijkstra[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.n]) {
                continue;
            }

            visited[now.n] = true;

            for (Node node : list[now.n]) {
                int newWeight = now.cost + node.cost;
                int originWeight = dijkstra[node.n];

                if (newWeight < originWeight) {
                    dijkstra[node.n] = newWeight;
                    pq.add(new Node(node.n, newWeight));
                }
            }
        }
    }
}