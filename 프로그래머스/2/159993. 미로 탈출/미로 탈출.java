import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int col, row;
    static char[][] map;

    class Position {
        int x;
        int y;
        
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        
        map = new char[row][col];
        for (int i = 0; i < row; i++) {
            char[] s = maps[i].toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = s[j];
            }
        }
        
        Position start = null, end = null, lever = null;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 'S') start = new Position(i, j);
                else if (map[i][j] == 'E') end = new Position(i, j);
                else if (map[i][j] == 'L') lever = new Position(i, j);
            }
        }
        
        int count1 = bfs(start, lever);
        if (count1 == -1) return -1;
        int count2 = bfs(lever, end);
        if (count2 == -1) return -1;
        
        return count1 + count2;
    }
    
    public int bfs(Position start, Position end) {
        Queue<Position> q = new LinkedList<>();
        q.add(start);
        int[][] visited = new int[row][col];
        visited[start.x][start.y] = 0;
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            
            if (x == end.x && y == end.y) {
                return visited[x][y];
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
                if (map[nextX][nextY] == 'X' || visited[nextX][nextY] > 0) continue;
                
                q.add(new Position(nextX, nextY));
                visited[nextX][nextY] = visited[x][y] + 1;
            }
        }
        
        return -1;
    }
}