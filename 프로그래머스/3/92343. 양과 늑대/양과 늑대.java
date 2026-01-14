import java.util.*;

class Solution {
    List<Integer>[] tree;
    int maxSheep;

    public int solution(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
        
        Set<Integer> init = new HashSet<>();
        for (int node : tree[0]) {
            init.add(node);
        }
        
        dfs(1, 0, info, init);
        
        return maxSheep;
    }
    
    public void dfs(int sheep, int wolf, int[] info, Set<Integer> candidates) {
        maxSheep = Math.max(sheep, maxSheep);
        
        for (int next : candidates) {
            Set<Integer> newCandidates = new HashSet<>(candidates);
            newCandidates.remove(next);
            
            for (int child : tree[next]) {
                newCandidates.add(child);
            }
            
            if (info[next] == 0) {
                dfs(sheep + 1, wolf, info, newCandidates);
            } else if (sheep > wolf + 1) {
                dfs(sheep, wolf + 1, info, newCandidates);
            }
        }
    }
}