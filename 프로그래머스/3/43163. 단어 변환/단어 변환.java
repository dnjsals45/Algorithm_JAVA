import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean possible = false;
        
        for (String word : words) {
            if (word.equals(target)) {
                possible = true;
                break;
            }
        }
        
        if (!possible) return 0;
        
        boolean[] visited = new boolean[words.length];
        
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        
        while (!q.isEmpty()) {
            Word cur = q.poll();
            
            if (cur.word.equals(target)) return cur.depth;
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(cur.word, words[i])) {
                    visited[i] = true;
                    q.add(new Word(words[i], cur.depth + 1));
                }
            }
        }
        
        int answer = 0;
        return answer;
    }
    
    private boolean canConvert(String word, String target) {
        int diff = 0;
        
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) diff++;
        }
        
        return diff == 1;
    }
    
    public class Word {
        String word;
        int depth;
        
        public Word(String w, int d) {
            this.word = w;
            this.depth = d;
        }
        
    }
}