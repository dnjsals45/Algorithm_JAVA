import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        int answer = 0;
        
        for (int[] dot : rectangle) {
            int x1 = dot[0] * 2;
            int x2 = dot[2] * 2;
            int y1 = dot[1] * 2;
            int y2 = dot[3] * 2;
            
            for (int i = x1; i <= x2; i++) {
                map[i][y1] = 1;
                map[i][y2] = 1;
            }
            
            for (int j = y1; j <= y2; j++) {
                map[x1][j] = 1;
                map[x2][j] = 1;
            }
        }
        
        for (int[] dot : rectangle) {
                int x1 = dot[0] * 2;
                int x2 = dot[2] * 2;
                int y1 = dot[1] * 2;
                int y2 = dot[3] * 2;
                
                for (int i = x1 + 1; i < x2; i++) {
                    for (int j = y1 + 1; j < y2; j++) {
                        map[i][j] = 0;
                    }
                }
        }
        
        int[] character = {characterX * 2, characterY * 2, 0};
        int[] item = {itemX * 2, itemY * 2};

        return bfs(map, character, item);
    }
    
    public int bfs(int[][] map, int[] character, int[] item) {
        boolean[][] visited = new boolean[101][101];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(character);
        visited[character[0]][character[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowDistance = now[2];
            
            if (nowX == item[0] && nowY == item[1]) {
                return nowDistance / 2;
            }
            
            for (int[] direction : directions) {
                int nextX = nowX + direction[0];
                int nextY = nowY + direction[1];
                
                if (nextX >= 0 && nextX < 101 && nextY >= 0 && nextY < 101 && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
                    queue.add(new int[]{nextX, nextY, nowDistance + 1});
                    visited[nextX][nextY] = true;
                }
            }
            
        }
        return -1;
    }
}