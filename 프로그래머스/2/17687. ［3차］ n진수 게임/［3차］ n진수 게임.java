import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int number = 0;
        
        while (sb.length() < t * m) {
            sb.append(format(number, n));
            number++;
        }
        
        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt(p - 1 + i * m));
        }

        return answer.toString();
    }
    
    public String format(int number, int n) {
        StringBuilder sb = new StringBuilder();
        String digits = "0123456789ABCDEF";
        
        if (number == 0) return "0";
        
        while (number > 0) {
            sb.append(digits.charAt(number % n));
            number /= n;
        }
        
        return sb.reverse().toString();
    }
}