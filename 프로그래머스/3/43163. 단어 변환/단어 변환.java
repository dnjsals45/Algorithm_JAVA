class Solution {
    static int answer = 0;
    static boolean possible = false;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        // 최종 변환이 불가능하다면 애초에 로직을 돌리지 않고 바로 return시킴
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                possible = true;
            }
        }
        if (possible == false) {
            return 0;
        }
        
        visited = new boolean[words.length];
        find(begin, target, words);
        return answer;
    }
    
    static void find(String current, String target, String[] words) {
        // 단어 다른 개수가 몇개인가?(diff)
        int diff = 0;
        
        // 현재 current index의 visited를 true로 변경
        for (int i = 0; i < words.length; i++) {
            if (current.equals(words[i])) {
                visited[i] = true;
            }
        }
        
        // current와 target의 단어 차이 개수가 1개밖에 나지 않는다면 바로 변환 가능
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != target.charAt(i))
                diff++;
        }
        if (diff == 1) {
            answer++;
            return;
        }
        
        // 그게 아니라면 중간 변환 과정이 필요함
        for (int i = 0; i < words.length; i++) {
            diff = 0;
            for (int j = 0; j < current.length(); j++) {
                if (current.charAt(j) != words[i].charAt(j))
                    diff++;
            }
            if (diff == 1 && !visited[i]) {
                find(words[i], target, words);
                answer++;
                return;
            }
        }
    }
}