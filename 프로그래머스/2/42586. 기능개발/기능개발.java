import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int remainDay = (remain + speeds[i] - 1) / speeds[i];
            q.add(remainDay);
        }
        
        List<Integer> result = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int count = 1;
            
            while (!q.isEmpty() && q.peek() <= cur) {
                q.poll();
                count++;
            }
            
            result.add(count);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}