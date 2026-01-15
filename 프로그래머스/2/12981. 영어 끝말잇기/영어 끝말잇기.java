import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char prev = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            if (set.contains(words[i]) || words[i].charAt(0) != prev) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            
            set.add(words[i]);
            prev = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0, 0};
    }
}