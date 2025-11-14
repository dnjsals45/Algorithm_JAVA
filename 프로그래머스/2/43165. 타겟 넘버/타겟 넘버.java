class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int now, int depth) {
        if (depth == numbers.length) {
            if (now == target) {
                answer++;
            }
            return;
        }
        
        dfs(numbers, target, now + numbers[depth], depth + 1);
        dfs(numbers, target, now - numbers[depth], depth + 1);
    }
}