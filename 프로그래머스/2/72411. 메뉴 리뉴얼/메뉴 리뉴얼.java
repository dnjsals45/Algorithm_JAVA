import java.util.*;

class Solution {
    
    public String[] solution(String[] orders, int[] course) {
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        List<String> answer = new ArrayList<>();

        for (int count : course) {
            map.put(count, new HashMap<>());
        }
        
        for (int count : course) {
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                combination(0, count, new String(arr), new StringBuilder(), map.get(count), 0);
            }
        }
        
        for (int count : course) {
            int max = 2;
            List<String> list = new ArrayList<>();
            for (String key : map.get(count).keySet()) {
                int tmp = map.get(count).get(key);
                if (tmp > 1) {
                    if (tmp > max) {
                        max = tmp;
                        list.clear();
                        list.add(key);
                    } else if (tmp == max) {
                        list.add(key);
                    }
                }
            }
            answer.addAll(list);
        }
        
        Collections.sort(answer);
        
        return answer.stream().toArray(String[]::new);
    }
    
    public void combination(int depth, int count, String order, StringBuilder now, Map<String, Integer> map, int index) {
        if (now.length() == count) {
            map.put(now.toString(), map.getOrDefault(now.toString(), 0) + 1);
            return;
        }
        
        for (int i = index; i < order.length(); i++) {
            now.append(order.charAt(i));
            combination(depth + 1, count, order, now, map, i + 1);
            now.deleteCharAt(now.length() - 1);
        }
        
    }
}