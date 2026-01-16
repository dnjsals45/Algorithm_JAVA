import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }
        
        return set.size();
    }
    
    public int find(int x) {
        if (parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        
        parent[root1] = root2;
    }
}