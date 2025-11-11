import java.util.*;

class Solution {
    // 알파벳 개수 총 26개
    // (현재 위치 인덱스 값 + n) % 26 -> 다음 인덱스 값
    // 'A' or 'a' 를 더해서 char 값으로 변환
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char next = (char) ((c - 'A' + n) % 26 + 'A');
                sb.append(next);
            } else if (Character.isLowerCase(c)) {
                char next = (char) ((c - 'a' + n) % 26 + 'a');
                sb.append(next);
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}