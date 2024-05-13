import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> comb = new HashMap<>();
        
        for (String[] cloth : clothes) {
            comb.put(cloth[1], comb.getOrDefault(cloth[1], 0) + 1);
        }
        
        for (int cnt : comb.values()) {
            answer *= (cnt + 1);
        }
        
        return answer - 1;
    }
}