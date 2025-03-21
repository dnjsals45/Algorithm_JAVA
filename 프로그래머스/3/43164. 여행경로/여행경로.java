import java.util.*;

class Solution {
    List<String> answer;
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        List<String> result = new ArrayList<>();
        result.add("ICN");
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        dfs("ICN", tickets, result, visited, 0);
        
        return answer.toArray(new String[0]);
    }
    
    private void dfs(String start, String[][] tickets, List<String> result, boolean[] visited, int depth) {
        if (depth == tickets.length) {
            if (answer == null) {
                answer = new ArrayList<>(result);
            }
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                result.add(tickets[i][1]);
                
                dfs(tickets[i][1], tickets, result, visited, depth + 1);
                
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}