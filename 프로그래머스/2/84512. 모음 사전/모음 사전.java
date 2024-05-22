import java.util.*;

class Solution {
    List<String> wordSet;
    char[] charSet;
    int count;
    int answer;
    public int solution(String word) {
        charSet = new char[]{'A', 'E', 'I', 'O', 'U'};
        wordSet = new ArrayList<>();
        
        dfs(0, word, "");
        
        return answer;
    }
    
    public void dfs(int depth, String word, String now) {
        if (now.equals(word)) {
            answer = count;
            return;
        }
        
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i < charSet.length; i++) {
            String tmp = now + charSet[i];
            count++;
            dfs(depth + 1, word, tmp);
        }
    }
}