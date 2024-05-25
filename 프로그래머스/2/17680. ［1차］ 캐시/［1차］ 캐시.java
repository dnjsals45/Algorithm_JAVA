import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> cache = new LinkedList<>();
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String city : cities) {
            String upperCity = city.toUpperCase();
            
            if (cache.contains(upperCity)) {
                answer += 1;
                cache.remove(upperCity);
                cache.addLast(upperCity);
            } else {
                if (cache.size() == cacheSize) {
                    cache.removeFirst();
                }
                
                cache.addLast(upperCity);
                answer += 5;
            }
            
        }
        
        return answer;
    }
}