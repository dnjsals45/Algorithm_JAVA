import java.util.*;

class Solution {
    private static int answer;
    private boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        solve(k, dungeons, 0);
        
        return answer;
    }
    
    public void solve(int k, int[][] dungeons, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                solve(k - dungeons[i][1], dungeons, cnt + 1);
                answer = Math.max(answer, cnt + 1);
                visited[i] = false;
            }
        }
    }
}