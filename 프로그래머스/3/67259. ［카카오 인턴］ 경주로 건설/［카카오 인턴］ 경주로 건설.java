import java.util.*;

class Solution {
    class Node {
        int x;
        int y;
        int direction;
        int cost;
        
        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    
    static int[] rx = {0, -1, 0, 1};
    static int[] ry = {-1, 0, 1, 0};
    static int[][][] visited;
    static int N;
    
    public int solution(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, -1, 0));
        N = board.length;
        visited = new int[N][N][4];
        
        int answer = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + rx[i];
                int nextY = cur.y + ry[i];
                
                if (isBlocked(board, nextX, nextY)) continue;
                
                int newCost = calculate(i, cur.direction, cur.cost);
                
                if (nextX == N - 1 && nextY == N - 1) {
                    answer = Math.min(answer, newCost);
                } else if (isShouldUpdate(nextX, nextY, i, newCost)) {
                    visited[nextX][nextY][i] = newCost;
                    q.add(new Node(nextX, nextY, i, newCost));
                }
            }
        }

        return answer;
    }
    
    private boolean isBlocked(int[][] board, int x, int y) {
        return (x == 0 && y == 0) || !isValid(x, y) || board[x][y] == 1;
    }

    private boolean isValid(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < N;
    }

    private int calculate(int direction, int prevDirection, int cost) {
        if (prevDirection == -1 || (prevDirection - direction) % 2 == 0) {
            return cost + 100;
        }

        return cost + 600;
    }

    private boolean isShouldUpdate(int x, int y, int direction, int cost) {
        return visited[x][y][direction] == 0 || visited[x][y][direction] > cost;
    }
}