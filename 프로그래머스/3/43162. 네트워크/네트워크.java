import java.util.*;

class Solution {
    // 방문 여부
    static boolean[] visited;
    // 인접 행렬
    static int[][] node;
    // bfs에 사용할 Queue 생성
    static Queue<Integer> queue = new LinkedList<>();
    // 최종 결과
    static int result = 0;
    
    public int solution(int n, int[][] computers) {
        // 방문 여부 생성
        visited = new boolean[n];
        // 인접 행렬 생성
        node = new int[n][n];
        // 인접 행렬 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    node[i][j] = 1;
                }
            }
        }
        
        // 0번 컴퓨터(그림에서는 1번) 부터 차례로 bfs 적용
        // node가 끊어져 있을 수 있기 때문에 모든 경우를 다 적용
        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 노드라면(형성된 네트워크 이외의 네트워크라면)
            if (!visited[i]) {
                // 새로운 네트워크 등록
                result++;
            }
            bfs(i, n);
        }
        
        return result;
    }
    
    // static 형태로 visited와 node를 생성하엿기 때문에 인자로 따로 받지 않음
    static void bfs(int start, int n) {
        // 큐에 start 담기
        queue.offer(start);
        
        // 큐가 빌때까지(연결된 노드를 모두 방문할 때까지)
        while (!queue.isEmpty()) {
            // 현재 위치를 뽑고
            int now = queue.poll();
            // 현재 방문한 곳을 true로 변경
            visited[now] = true;
            for (int i = 0; i < n; i++) {
                // node가 1이고 아직 방문하지 않았다면
                if (node[now][i] == 1 && !visited[i]) {
                    // 방문한 node를 큐에 추가하고, 방문한 것으로 변경
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}