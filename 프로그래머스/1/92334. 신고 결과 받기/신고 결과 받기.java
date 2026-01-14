import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportCount = new HashMap<>();
        
        for (String s : report) {
            String user = s.split(" ")[0];
            String reported = s.split(" ")[1];
            
            if (!reportMap.containsKey(reported)) {
                reportMap.put(reported, new HashSet<>());
            }
            
            reportMap.get(reported).add(user);
        }
        
        for (Map.Entry<String, Set<String>> entry : reportMap.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String uid : entry.getValue()) {
                    reportCount.put(uid, reportCount.getOrDefault(uid, 0) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reportCount.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}