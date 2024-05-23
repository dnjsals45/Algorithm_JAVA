import java.util.*;

class Solution {
    public int solution(String name) {
        char[] word = new char[name.length()];
        int answer = 0;
        
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); // 문자열 전부 변경 횟수
        }
        
        int min = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
           min = Math.min(min, i + name.length() - next + Math.min(i, name.length() - next));
        }
        
        answer += min;
        return answer;
    }
}