import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps, 0, 0);
    }
    
    public int bfs(int[][] maps, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        visited[x][y] = true;
        
        queue.add(new int[]{x, y, 1});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowDistance = now[2];
            
            if (nowX == maps.length - 1 && nowY == maps[0].length - 1) {
                return nowDistance;
            }
            
            for (int[] direction : directions) {
                int nextX = nowX + direction[0];
                int nextY = nowY + direction[1];
                
                if (nextX >= 0 && nextX < maps.length && nextY >= 0 && nextY < maps[0].length && !visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                    queue.add(new int[]{nextX, nextY, nowDistance + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        return -1;
    }
}