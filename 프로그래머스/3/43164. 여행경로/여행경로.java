import java.util.*;

class Solution {
    static ArrayList<String> path = new ArrayList<>();
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs(tickets, "ICN", "ICN", 0);
        
        Collections.sort(path);
        
        return path.get(0).split(" ");
    }
    
    static void dfs(String[][] tickets, String now, String next, int depth) {
        if (depth == tickets.length) {
            path.add(next);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], next + " " + tickets[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
    
}