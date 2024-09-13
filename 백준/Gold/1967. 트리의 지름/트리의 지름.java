import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int end;
        int distance;

        Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }

    static int longNode;
    static int max;
    static boolean[] visited;
    static List<Node>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        // 노드의 개수 n
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, distance));
            list[end].add(new Node(start, distance));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(longNode, 0);

        System.out.println(max);
    }

    static void dfs(int start, int distance) {
        if (distance > max) {
            max = distance;
            longNode = start;
        }

        visited[start] = true;

        for (Node node : list[start]) {
            if (!visited[node.end]) {
                dfs(node.end, distance + node.distance);
            }
        }
    }
}
