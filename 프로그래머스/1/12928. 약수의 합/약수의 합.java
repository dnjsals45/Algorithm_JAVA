import java.util.*;

class Solution {
    public int solution(int n) {
        if (n == 1) return 1;
        
        int answer = 0;
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                answer += i;
                // 완전제곱수일 때 중복 합산 방지
                if (i != n / i) {
                    answer += n / i;
                }
            }    
        }
        
        return answer;
    }
}