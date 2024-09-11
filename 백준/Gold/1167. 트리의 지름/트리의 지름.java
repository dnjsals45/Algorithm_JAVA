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

    static int max;
    static int longNode;
    static boolean[] visited;
    static List<Node>[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 트리의 정점의 개수 V
        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);

            for (int j = 1; j < input.length; j++) {
                if (input[j].equals("-1")) {
                    break;
                }

                int end = Integer.parseInt(input[j++]);
                int distance = Integer.parseInt(input[j]);
                tree[start].add(new Node(end, distance));
            }
        }

        // 어느 한 정점으로부터 가장 먼곳에 있는 정점을 구한다.
        visited = new boolean[V + 1];
        dfs(1, 0);

        // 그리고 나서 그 정점에서 가장 먼 정점을 구해 그 사이의 길이를 구한다.
        visited = new boolean[V + 1];
        dfs(longNode, 0);

        System.out.println(max);
    }

    static void dfs(int start, int distance) {
        if (distance > max) {
            max = distance;
            longNode = start;
        }

        visited[start] = true;

        for(int i = 0; i < tree[start].size(); i++) {
            Node next = tree[start].get(i);
            if (!visited[next.end]) {
                dfs(next.end, distance + next.distance);
            }
        }
    }
}
