import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {        
        int sum = brown + yellow;
        
        for (int y = 1; y <= sum; y++) {
            if (sum % y == 0) {
                int x = sum / y;
                
                if ((x - 2) * (y - 2) == yellow) {
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }
}