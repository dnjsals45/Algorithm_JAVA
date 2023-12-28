import java.util.*;
import java.math.*;

class Solution {
    /**
    *   문제 접근 과정
    *   야근 피로도는 제곱을 더한 값이기 때문에, 제곱이 되는 수를 최소화 하는 것이 중요할 것.
    *   현재 works에서 가장 큰 값을 찾아서 1을 빼는 작업을 n번 반복한다 -> 결과값 최소화
    *   시간초과 -> 차라리 먼저 정렬을 한 후에 works를 무작정 탐색하지 말고 앞에서부터 값을 뺀다?
    **/
    public long solution(int n, int[] works) {
        int max = 0;
        long answer = 0;
        
        // 오름차순
        Arrays.sort(works);
        for (int i = 0; i < n; i++) {
            int maxIndex = findMaxIndex(works);
            if (works[maxIndex] == 0)
                return 0;
            works[maxIndex]--;
        }
        
        for (int i = 0; i < works.length; i++) {
            answer += Math.pow(works[i], 2);
        }
        return answer;
    }
    
    static int findMaxIndex(int[] works) {
        for (int i = works.length - 1; i >= 0; i--) {
            if (i == 0)
                break;
            if (works[i] > works[i - 1]) {
                return i;
            }
        }
        return 0;
    }
}