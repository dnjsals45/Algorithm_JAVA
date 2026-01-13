import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for (String man : participant) {
            if (map.getOrDefault(man, 0) == 0) return man;
            map.put(man, map.get(man) - 1);
        }
        
        return null;
    }
}