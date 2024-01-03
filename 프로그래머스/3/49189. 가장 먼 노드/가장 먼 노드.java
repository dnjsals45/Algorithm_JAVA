import java.util.*;

/**
*   int[][] 형태로 map을 선언하였을 시 메모리 초과가 발생
*   인접행렬 -> 인접리스트 방식으로 변경
*/

class Solution {
    static boolean[] visited;
    static List<Integer>[] map;
    static int answer = 0;
    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];
        map  = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        
        for (int[] point : edge) {
            map[point[0]].add(point[1]);
            map[point[1]].add(point[0]);
        }
        
        bfs(n, 1);

        return answer;
    }
    
    static void bfs(int n, int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        
        int size = 0;        
        
        while(!queue.isEmpty()) {
            size = queue.size();
            answer = size;
            
            for (int i = 0; i < size; i++) { 
                int now = queue.poll();
                
                for (int next : map[now]) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
    }
}
