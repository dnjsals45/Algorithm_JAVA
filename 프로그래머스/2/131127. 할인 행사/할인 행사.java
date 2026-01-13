import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> product = new HashMap<>();
        
        int total = 0;
        for (int i : number) {
            total += i;
        }
        
        for (int i = 0; i < want.length; i++) {
            product.put(want[i], number[i]);
        }
        
        int answer = 0;
        for (int i = 0; i < discount.length - total + 1; i++) {
            HashMap<String, Integer> dcMap = new HashMap<>();
            for (int j = i; j < i + total; j++) {
                dcMap.put(discount[j], dcMap.getOrDefault(discount[j], 0) + 1);
            }
            if (product.equals(dcMap)) answer++;
        }
        
        return answer;
    }
}