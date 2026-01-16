import java.util.*;

class Solution {
    public static int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        int count = 0;
        
        for (int[] edge : costs) {
            if (count == n - 1) return answer;
            
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                count++;
            }
        }
        
        return answer;
    }
    
    public int find(int n) {
        if (parent[n] == n) {
            return n;
        } 
        
        return parent[n] = find(parent[n]);
    }
    
    public void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);
        
        parent[root2] = root1;
    }
}