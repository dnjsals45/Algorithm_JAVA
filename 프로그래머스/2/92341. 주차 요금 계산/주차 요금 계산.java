import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> time = new HashMap<>();
        Map<String, Integer> duration = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] data = records[i].split(" ");
            String timeData = data[0];
            String car = data[1];
            String status = data[2];
            if (status.equals("IN")) {
                String[] t = timeData.split(":");
                String hour = t[0];
                String minute = t[1];
                int start = Integer.parseInt(hour) * 60 + Integer.parseInt(minute);        
                time.put(car, start);
                if (!duration.containsKey(car)) {
                    duration.put(car, 0);
                }
            } else {
                String[] t = data[0].split(":");
                String hour = t[0];
                String minute = t[1];
                
                int before = time.remove(car);
                int after = Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
                duration.put(car, duration.get(car) + after - before);
            }
        }
        
        for (String key : time.keySet()) {
            int before = time.get(key);
            int after = (23 * 60) + 59;
            int durationData = duration.get(key);
            
            duration.put(key, durationData + (after - before));
        }
        
        List<String> keys = new ArrayList<>();
        
        for (String key : duration.keySet()) {
            keys.add(key);
        }
        
        Collections.sort(keys);
        
        for (String key : keys) {
            int totalDuration = duration.remove(key);
            int totalFee = 0;
            if (totalDuration <= fees[0]) {
                totalFee = fees[1];
            } else {
                totalDuration -= fees[0];
                totalFee = fees[1] + (int)Math.ceil((double)totalDuration / fees[2]) * fees[3];
            }
            
            answer.add(totalFee);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}