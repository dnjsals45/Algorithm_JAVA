// yellow 가장 적은 차이의 곱 (ex 24면 2 * 12가 아니라 4 * 6) 에서, 가로 세로 +2 씩 하면 정답(가로가 더 큰거)
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {

        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                int j = yellow / i;
                if ((i + 2) * (j + 2) == brown + yellow) {
                    return new int[]{j + 2, i + 2};
                }
            }
        }
        
        return new int[]{};
    }
}