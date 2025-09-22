class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int sign = 1;
        for (char c : s.toCharArray()) {
            if (c == '-') sign *= -1;
            else if (c == '+') continue;
            else {
                answer *= 10;
                int i = Integer.valueOf(c - '0');
                answer += i;
            }
        }
        
        return sign * answer;
    }
}