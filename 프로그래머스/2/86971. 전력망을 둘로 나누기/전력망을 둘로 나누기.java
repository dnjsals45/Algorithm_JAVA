import java.util.*;

class Solution {
    static int[][] map;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        map = new int[n + 1][n + 1];
        
        for (int i = 0; i < wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            map[a][b] = 0;
            map[b][a] = 0;
            
            answer = Math.min(answer, bfs(a, n));
            
            map[a][b] = 1;
            map[b][a] = 1;
        }
               
        return answer;
    }
    
    public int bfs(int a, int n) {
        int cnt = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(a);
        
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            visited[tmp] = true;
            for (int i = 1; i < n + 1; i++){
                if (map[tmp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    cnt++;
                }
            }
        }
        
        return Math.abs(cnt - (n - cnt));
    }
}