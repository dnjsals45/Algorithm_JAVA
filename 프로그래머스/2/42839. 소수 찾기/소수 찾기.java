import java.util.*;

class Solution {
    static Set<Integer> numberSet = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];    
        generateNumbers("", numbers);
        
        int answer = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public void generateNumbers(String cur, String numbers) {
        if (!cur.isEmpty()) {
            numberSet.add(Integer.parseInt(cur));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateNumbers(cur + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}