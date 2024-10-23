import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Node> list = new ArrayList<>();


        String[] first = br.readLine().split(" ");
        int V = Integer.parseInt(first[0]);
        int E = Integer.parseInt(first[1]);

        for (int i = 0; i < E; i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            list.add(new Node(start, end, weight));
        }

        Collections.sort(list);

        int[] parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        long result = 0;
        for (Node node : list) {
            int start = node.start;
            int end = node.end;
            int weight = node.weight;

            if (findParent(parent, start) != findParent(parent, end)) {
                unionParent(parent, start, end);
                result += weight;
            }
        }

        System.out.println(result);
    }

    public static int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
