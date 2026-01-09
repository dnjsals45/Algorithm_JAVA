import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        
        for (char c : dirs.toCharArray()) {
            int nx = x, ny = y;
            if (c == 'U') ny++;
            else if (c == 'D') ny--;
            else if (c == 'L') nx--;
            else nx++;
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            String path = Math.min(x, nx) + "," + Math.min(y, ny) + "->" + Math.max(x, nx) + "," + Math.max(y, ny);
          visited.add(path);

          x = nx;
          y = ny;
        }
        
        return visited.size();
    }
}