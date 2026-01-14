import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String cur = seller[i];
            int money = amount[i] * 100;
            while (money > 0 && !cur.equals("-")) {
                count.put(cur, count.getOrDefault(cur, 0) + money - (money / 10));
                cur = parent.get(cur);
                money /= 10;
            }
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = count.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}