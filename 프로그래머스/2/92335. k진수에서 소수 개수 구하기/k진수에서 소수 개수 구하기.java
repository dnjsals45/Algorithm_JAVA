import java.util.*;

class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        
        String st = convert(n, k);
        
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '0') {
                if (sb.length() != 0 && isPrime(Long.parseLong(sb.toString()))) {
                    answer++;
                }
                sb.setLength(0);
            } else {
                sb.append(st.charAt(i));
            }
        }
        
        if (sb.length() != 0 && isPrime(Long.parseLong(sb.toString()))) {
                    answer++;
        }
        return answer;
    }   
    
    public String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while (n >= k) {
            sb.append(n % k);
            n = n / k;
        }
        
        sb.append(n);
        
        return sb.reverse().toString();
    }
    
    public boolean isPrime(Long n) {
        if (n <= 1) {
            return false;
        }
        
        if (n == 2) {
            return true;
        }
        
        if (n % 2 == 0) {
            return false;
        }
        
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}