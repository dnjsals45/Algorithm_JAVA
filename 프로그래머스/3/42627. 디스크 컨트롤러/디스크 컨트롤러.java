import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 0ms에서 시작하는 작업을 파악하기 위해 jobs 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int index = 0;
        int end = 0;
        int count = 0;
        
        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index]);
                index++;
            }
            
            if (pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] current = pq.poll();
                answer += current[1] + end - current[0];
                end += current[1];
                count++;
            }
        }
        
        return answer / jobs.length;
    }
}