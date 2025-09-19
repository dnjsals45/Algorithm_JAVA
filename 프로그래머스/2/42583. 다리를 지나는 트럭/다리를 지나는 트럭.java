import java.util.*;

class Solution {
    // 다리가 시간을 지나는데는 bridge_length 초 만큼 필요
    // 정해진 순으로 건너기 때문에 트럭을 순서대로 보내기만 하면 됨
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new LinkedList<>();
        Queue<Integer> waiting = new LinkedList<>();
        
        for (int truck : truck_weights) {
            waiting.offer(truck);
        }
        
        int time = 0;
        int nowWeight = 0;
        
        while (!waiting.isEmpty()) {
            time++;
            
            // 1초 후에 다리에서 나가게 되는 트럭이 있나 파악
            if (!bridge.isEmpty() && bridge.peek()[1] == time) {
                nowWeight -= bridge.poll()[0];    
            }
            
            // 다음 트럭 무게 확인
            int next = waiting.peek();
            
            if (nowWeight + next <= weight) {
                waiting.poll();
                // bridge_length 초 이후에 다리를 빠져나가므로 현재 시간에 bridge_length 만큼 더한
                // 시간이 퇴장 시간이 됨
                bridge.offer(new int[]{next, time + bridge_length});
                nowWeight += next;
            }
        }
        
        // while문에서 대기중인 트럭이 비었는지 여부만 판단하기 때문에
        // 마지막 트럭은 추적되지 않음. 따라서 마지막 트럭이 나가는 시간을 합해줌
        return time + bridge_length;
    }
}