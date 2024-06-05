import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minEnd = gems.length;
        
        for (String gem : gems) {
            gemSet.add(gem);
        }
        
        while (true) {
            if (map.size() == gemSet.size()) {
                if (minEnd - minStart > end - start) {
                    minStart = start;
                    minEnd = end;
                }
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            } else if (end == gems.length) {
                break;
            } else {
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                end++;
            }
        }
        
        return new int[]{minStart + 1, minEnd};
    }
}