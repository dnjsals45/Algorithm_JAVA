import java.util.*;

class Solution {
    public static Map<Integer, Map<String, Integer>> map;
    
    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        
        for (int c : course) {
            map.put(c, new HashMap<>());
        }
        
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            comb(arr, "", 0);
        }
        
        List<String> answer = new ArrayList<>();
        
        for (Map<String, Integer> orderMap : map.values()) {
            int max = 0;
            
            for (int cnt : orderMap.values()) {
                max = Math.max(max, cnt);
            }
            
            if (max > 1) {
                for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
                    if (entry.getValue() == max) {
                        answer.add(entry.getKey());
                    }
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    public void comb(char[] arr, String now, int depth) {
        if (map.containsKey(now.length())) {
            Map<String, Integer> orderMap = map.get(now.length());
            orderMap.put(now, orderMap.getOrDefault(now, 0) + 1);
        }
        
        for (int i = depth; i < arr.length; i++) {
            comb(arr, now + arr[i], i + 1);
        }
    }
}