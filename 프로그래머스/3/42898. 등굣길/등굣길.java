class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        // 초기화 부분(시작지점 1로 설정)
        int[][] map = new int[n][m];
        map[0][0] = 1;
        
        // 물웅덩이 부분 -1로 설정
        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                
                if (i != 0) {
                    map[i][j] += map[i - 1][j] % 1000000007;
                }
                
                if (j != 0) {
                    map[i][j] += map[i][j - 1] % 1000000007;
                }
            }
        }
        
        
        return map[n - 1][m - 1] % 1000000007;
    }
}