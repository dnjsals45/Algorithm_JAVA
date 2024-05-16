import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] complete = new int[progresses.length];
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            if (((100 - progresses[i]) % speeds[i]) == 0) {
                complete[i] = (100 - progresses[i]) / speeds[i];    
            } else {
                complete[i] = ((100 - progresses[i]) / speeds[i]) + 1;
            }
        }
        
        int count = 1;
        int prev = complete[0];
        for (int i = 1; i < complete.length; i++) {
            if (complete[i] > prev) {
                answer.add(count);
                count = 1;
                prev = complete[i];
            } else {
                count++;
            }
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}