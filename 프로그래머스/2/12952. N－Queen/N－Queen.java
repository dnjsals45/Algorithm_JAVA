class Solution {
    static int answer;
    
    public int solution(int n) {
        int[] queens = new int[n];
        
        solve(0, queens);
        
        return answer;
    }
    
    public void solve(int row, int[] queens) {
        if (row == queens.length) {
            answer++;
            return;
        }
        
        for (int col = 0; col < queens.length; col++) {
            if (isValid(row, col, queens)) {
                queens[row] = col;
                solve(row + 1, queens);
                queens[row] = 0;
            }
        }
    }
    
    public boolean isValid(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) {
                return false;
            }
            
            if (Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        
        return true;
    }
}