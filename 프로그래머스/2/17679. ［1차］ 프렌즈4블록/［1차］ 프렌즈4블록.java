import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        while (true) {
            boolean[][] visited = new boolean[m][n];
            boolean check = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == '0') {
                        continue;
                    }
                    char now = map[i][j];
                    if (map[i + 1][j] == now && map[i][j + 1] == now && map[i + 1][j + 1] == now) {
                        visited[i][j] = true;
                        visited[i + 1][j] = true;
                        visited[i][j + 1] = true;
                        visited[i + 1][j + 1] = true;
                        check = true;
                    }
                }
            }
              
            if (check == false) {
                    break;
            }
                
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == true) {
                        map[i][j] = '0';
                        answer++;
                    }
                }
            }
            
            for (int j = 0; j < n; j++) {
                int emptyIndex = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '0') {
                        char temp = map[i][j];
                        map[i][j] = '0';
                        map[emptyIndex][j] = temp;
                        emptyIndex--;
                    }
                }
            }
        }
        
        return answer;
    }
}