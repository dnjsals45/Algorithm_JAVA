import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;
        
        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    static int[] parent;
    public int solution(int n, int[][] costs) {
        List<Node> list = new ArrayList<>();
        
        for (int[] cost : costs) {
            list.add(new Node(cost[0], cost[1], cost[2]));
        }
        
        Collections.sort(list);
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        int count = 0;
        
        for (Node edge : list) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                answer += edge.cost;
                count++;
            }
            
            if (count == n - 1) break;
        }
        
        return answer;
    }
    
    public int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int x, int y) {
        x = find(x);
        y= find(y);
        if (x != y) parent[y] = x;
    }
}