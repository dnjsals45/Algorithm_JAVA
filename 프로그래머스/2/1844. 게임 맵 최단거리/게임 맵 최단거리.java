import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        int answer = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if (x == row - 1 && y == col - 1) return cnt;
            
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= row || nextX < 0 || nextY >= col || nextY < 0 || maps[nextX][nextY] == 0 || visited[nextX][nextY]) continue;
                
                q.add(new int[]{nextX, nextY, cnt + 1});
                visited[nextX][nextY] = true;
            }
        }
        
        return -1;
    }
}