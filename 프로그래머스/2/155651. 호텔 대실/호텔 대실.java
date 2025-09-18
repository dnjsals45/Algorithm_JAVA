import java.util.*;

class Solution {
    // 현재는 퇴실 시각만 존재하지만 퇴실시각 + 청소시각까지로 변경
    // HH:MM 대신 모두 분 형태로 변경해 리스트에 저장
    // 현재 퇴실정보를 저장하는 우선순위 큐 생성 -> 퇴실이 가장 빠른 객실 우선순위로 저장
    // 다음 사람이 입실해야할 때 입실정보 큐에 정보를 바탕으로 객실 수 추적
    public int solution(String[][] book_time) {
        List<int[]> list = new ArrayList<>();
        
        // 시:분 대신 비교하기 쉽도록 분의 형태로 리스트에 저장
        for(String[] book : book_time) {
            int start = convertHourToMinute(book[0]);
            int end = convertHourToMinute(book[1]);
            
            list.add(new int[]{start, end + 10});
        }
        
        // 입실시간이 가장 빠른 시간 순으로 정렬
        list.sort((o1, o2) -> o1[0] - o2[0]);
        
        // 퇴실 정보를 저장하는 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int result = 0;
        
        for (int[] book : list) {
            int curStart = book[0];
            int curEnd = book[1];
            
            // 현재 입실시간보다 큐 최상단 퇴실정보가 빠르거나 같으면 제거
            // (이미 다 사용하고 청소까지 마무리한 숙소)
            while (!pq.isEmpty() && pq.peek() <= curStart) {
                pq.poll();
            }
            
            // 새로운 퇴실정보 저장
            pq.add(curEnd);
            
            // 현재 result와 우선순위 큐 크기 중 더 큰 값을 저장
            result = Math.max(result, pq.size());
        }
        
        return result;
    }
    
    private int convertHourToMinute(String time) {
        Integer hour = Integer.valueOf(time.split(":")[0]);
        Integer minute = Integer.valueOf(time.split(":")[1]);
        
        return hour * 60 + minute;
    }
}