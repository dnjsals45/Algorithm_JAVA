class Solution {
    public long solution(long n) {
        long num = (long) Math.pow(Math.ceil(Math.sqrt(n)), 2);
        
        if (num == n) return (long) Math.pow(Math.sqrt(n) + 1, 2);
        else return -1;
    }
}