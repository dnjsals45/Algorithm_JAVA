import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            int term = 0;
            for (int j = i + 1; j < prices.length; j++) {
                term++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = term;
        }
        
        return answer;
    }
}