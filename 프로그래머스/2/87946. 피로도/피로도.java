class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    
    private void dfs(int k, int[][] dungeons, int cnt) {
        answer = Math.max(answer, cnt);
        
        for (int i = 0; i < dungeons.length; i++) {
            int[] dungeon = dungeons[i];
            if (!visited[i] && k - dungeon[0] >= 0) {
                visited[i] = true;
                dfs(k - dungeon[1], dungeons, cnt + 1);
                visited[i] = false;
            }
        }
    }
}