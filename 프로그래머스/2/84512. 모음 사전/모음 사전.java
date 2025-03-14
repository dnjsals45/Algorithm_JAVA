import java.util.*;

class Solution {
    static int cnt = 1;
    static Map<String, Integer> dict = new HashMap<>();

    public int solution(String word) {
        char[] alpha = new char[]{'A', 'E', 'I', 'O', 'U'};
        
        generateDict(alpha, "", 0);
        return dict.get(word);
    }
    
    private void generateDict(char[] alpha, String cur, int depth) {
        if (!cur.isEmpty()) {
            dict.put(cur, cnt++);
        }
        if (depth == 5) return;
        
        for (int i = 0; i < 5; i++) {
            generateDict(alpha, cur + alpha[i], depth + 1);
        }
    }
}