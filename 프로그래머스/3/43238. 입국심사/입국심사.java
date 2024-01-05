import java.util.*;

// 최악의 경우 : 가장 긴 심사대에서 모든 인원이 심사를 받음 -> times[max] * n
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times); // 가장 적게 걸리는 시간과, 오래 걸리는 시간을 파악하기 위해 sort
        
        long start = times[0]; // 가장 시간이 적게 소요되는 심사대에서 첫번째 심사 시간
        long end = (long) n * (long) times[times.length - 1]; // 모든 인원이 가장 긴 심사대에서 받는 심사 시간
        
        // start와 end 시간 안에서 몇명을 검사할 수 있는지 체크한다.(이분탐색)
        while (start <= end) { // 
            long mid = (start + end) / 2;
            long check = 0;
            for (int time : times) {
                check += mid / time;
            }
            if (check < n) {
                start = mid + 1;
            } else if (check >= n) {
                end = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}