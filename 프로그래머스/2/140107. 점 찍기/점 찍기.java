import java.util.*;

class Solution {
    // 단순 거리 공식인 Math.sqrt(x*x + y*y) 와 비교하면 2중루프로 시간 초과 발생
    // 아래 식은 시간초과
//     public long solution(int k, int d) {
//         long answer = 0;
        
//         for (int x = 0; x <= k * d; x += k) {
//             for (int y = 0; y <= k * d; y += k) {
//                 if (x * x + y * y <= d * d) answer++;
//             }
//         } 
        
//         return answer;
//     }
    
    // O(d^2) 을 O(d) 로 변경
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int x = 0; x <= d; x += k) {
            long y = (long) Math.sqrt((long)d * d - (long)x * x);
            answer += y / k + 1;
        } 
        
        return answer;
    }
}