import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int price;

        Node(int end, int price) {
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return price - o.price;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시의 개수 n
        int n = Integer.parseInt(br.readLine());

        // 버스의 개수 m
        int m = Integer.parseInt(br.readLine());

        List<Node>[] list = new ArrayList[n + 1];
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            // 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;  // 자기 자신으로의 비용은 0
            dijkstra(i, list, dist[i]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(dist[i][j] == Integer.MAX_VALUE ? 0 + " " : dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dijkstra(int start, List<Node>[] list, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int end = current.end;
            int price = current.price;

            if (dist[end] < price) {
                continue;
            }

            for (Node node : list[end]) {
                int next = node.end;
                int nextPrice = price + node.price;

                if (nextPrice < dist[next]) {
                    dist[next] = nextPrice;
                    pq.offer(new Node(next, nextPrice));
                }
            }
        }
    }
}
