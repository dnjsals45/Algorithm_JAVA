import java.util.*;

class Solution {
    List<Integer> result;
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long eval = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        for (int num : queue1) {
            q1.add(Long.valueOf(num));
            sum1 += num;
        }
        
        for (int num : queue2) {
            q2.add(Long.valueOf(num));
            sum2 += num;
        }
        
        eval = sum1 + sum2;

        if (eval % 2 != 0) {
            return -1;
        }
        
        eval /= 2;
        
        while (count < (queue1.length + queue2.length) * 2 + 1) {
            if (sum1 == sum2 && sum1 == eval) {
                return count;
            }
            
            if (sum1 > eval) {
                long now = q1.poll();
                sum1 -= now;
                sum2 += now;
                q2.add(now);
            } else {
                long now = q2.poll();
                sum1 += now;
                sum2 -= now;
                q1.add(now);
            }
            
            count++;
        }
        
        return -1;
    }
}