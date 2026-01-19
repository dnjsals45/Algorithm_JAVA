import java.util.*;

class Solution {
    class Node {
        int end;
        int cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        List<Node>[] list = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road.length; i++) {
            list[road[i][0]].add(new Node(road[i][1], road[i][2]));
            list[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        
        pq.add(new Node(1, 0));
        dist[1] = 0;
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dist[cur.end] < cur.cost) continue;
            
            for (Node next : list[cur.end]) {
                if (dist[next.end] > cur.cost + next.cost) {
                    dist[next.end] = cur.cost + next.cost;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
}