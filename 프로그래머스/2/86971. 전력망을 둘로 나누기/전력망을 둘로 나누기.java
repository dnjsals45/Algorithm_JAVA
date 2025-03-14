import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            answer = Math.min(answer, bfs(graph, n, a));
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        return answer;
    }
    
    private int bfs (List<Integer>[] graph, int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        visited[start] = true;
        int cnt = 1;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        
        return Math.abs(cnt - (n - cnt));
    }
}