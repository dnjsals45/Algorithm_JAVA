class Solution {
    public long solution(int a, int b) {
        if (a == b) return (long) a;
        
        long max = (long) Math.max(a, b);
        long min = (long) Math.min(a, b);
        
        long answer = 0;
        
        for (long i = min; i <= max; i++) {
            answer += i;
        }
        
        return answer;
    }
}