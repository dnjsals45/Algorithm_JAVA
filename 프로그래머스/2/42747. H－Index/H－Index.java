import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] obj = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        int answer = 0;
        
        Arrays.sort(obj, Collections.reverseOrder());
        
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] >= i + 1) {
                answer = i + 1;
            } else {
                break;
            }
        }
        
        return answer;
    }
}