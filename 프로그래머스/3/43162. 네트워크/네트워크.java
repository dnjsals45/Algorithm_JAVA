import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int cur, int[][] computers, boolean[] visited) {
        visited[cur] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (i != cur && computers[cur][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}