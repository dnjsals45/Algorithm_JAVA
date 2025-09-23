import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // words 배열 내에 target이 없을 경우 early return
        if (!isPossible(words, target)) return 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        int answer = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            answer++;
            
            for (int s = 0; s < size; s++) {
                String cur = q.poll();

                for (int i = 0; i < words.length; i++) {
                    if (!visited[i] && canConvert(cur, words[i])) {
                        // 다음 번 변환 값이 target과 같다면 return
                        if (words[i].equals(target)) return answer;
                        visited[i] = true;
                        q.add(words[i]);
                    }
                }
            }
        }
        
        return answer;
    }
    
    // words 배열 내에 해당하는 단어 존재 여부 체크
    private boolean isPossible(String[] words, String target) {
        for (String word: words) {
            if (word.equals(target)) return true;
        }
        return false;
    }
    
    // 한 글자만 틀린지 체크
    private boolean canConvert(String word, String target) {
        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) diff++;
        }
        
        return diff == 1 ? true : false;
    }
}