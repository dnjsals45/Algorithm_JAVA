import java.util.*;

class Solution {
    // 초기 접근법 : 무게 2중 for문 & 거리 2중 for문 2개를 돌려 완전탐색 -> 시간초과
    // 우선 w1을 항상 작게 만들도록 정렬(동일, 2/3, 2/4, 3/4의 4가지 경우만 고려)
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int weight : weights) {
            answer += map.getOrDefault(weight, 0);
            if (weight * 2 % 3 == 0) answer += map.getOrDefault(weight * 2 / 3, 0);
            if (weight % 2 == 0) answer += map.getOrDefault(weight / 2, 0);
            if (weight * 3 % 4 == 0) answer += map.getOrDefault(weight * 3 / 4, 0);
            
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        
        return answer;
    }
}