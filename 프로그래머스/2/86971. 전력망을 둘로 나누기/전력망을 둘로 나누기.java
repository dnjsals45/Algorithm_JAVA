import java.util.*;

class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    static int N;
    static int answer;
    
    public int solution(int n, int[][] wires) {
        N = n;
        answer = n - 1;
        list = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        
        visited = new boolean[n + 1];
        dfs(1);
        
        return answer;
    }
    
    public int dfs(int now) {
        visited[now] = true;
        int sum = 0;
        
        for (int next : list[now]) {
            if (!visited[next]) {
                int cnt = dfs(next);
                answer = Math.min(answer, Math.abs(N - cnt * 2));
                
                sum += cnt;
            }
        }
        
        return sum + 1;
    }
}