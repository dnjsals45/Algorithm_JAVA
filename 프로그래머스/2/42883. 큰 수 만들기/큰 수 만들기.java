import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = number.toCharArray();
        
        int len = number.length() - k;
        int start = 0;
        
        for (int i = 0; i < len; i++) {
            char max = '0';
            for (int j = start; j <= i + k; j++) {
                if (charArray[j] > max) {
                    max = charArray[j];
                    start = j + 1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}