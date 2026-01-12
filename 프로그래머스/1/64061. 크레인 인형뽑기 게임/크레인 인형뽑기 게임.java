import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>[] lanes = new Stack[board.length];
        
        for (int i = 0; i < board.length; i++) {
            lanes[i] = new Stack<>();
        }
        
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }    
            }
        }
        
        Stack<Integer> basket = new Stack<>();
        int answer = 0;
        
        for (int move : moves) {
            if (!lanes[move - 1].isEmpty()) {
                int cur = lanes[move - 1].pop();
                
                if (!basket.isEmpty() && basket.peek() == cur) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(cur);
                }
            }
        }  
        
        return answer;
    }
}