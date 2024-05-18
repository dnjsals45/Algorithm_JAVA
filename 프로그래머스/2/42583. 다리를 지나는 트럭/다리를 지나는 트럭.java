import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int now = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        for (int truck : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.offer(truck);
                    now += truck;
                    answer++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    now -= bridge.poll();
                } else {
                    if (now + truck > weight) {
                        bridge.offer(0);
                        answer++;
                    } else {
                        bridge.offer(truck);
                        now += truck;
                        answer++;
                        break;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}