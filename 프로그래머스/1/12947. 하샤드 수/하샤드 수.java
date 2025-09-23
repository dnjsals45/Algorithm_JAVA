class Solution {
    public boolean solution(int x) {
        String v = String.valueOf(x);
        
        int sum = 0;
        for (char c : v.toCharArray()) {
            sum += c - '0';
        }
        
        return x % sum == 0 ? true : false;
    }
}