import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> players = new HashMap<>();
        
        for (String runner : participant) {
            players.put(runner, players.getOrDefault(runner, 0) + 1);
        }
        
        for (String complete : completion) {
            players.put(complete, players.get(complete) - 1);
        }
        
        for (Map.Entry<String, Integer> entry : players.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}