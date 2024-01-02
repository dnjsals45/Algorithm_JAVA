import java.math.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int before = 1;

        for (int station : stations) {
            int start = station - w;
            int end = station + w;
            answer += Math.ceil((double) (start - before) / (w * 2 + 1));
            before = end + 1;
        }

        if (before <= n) {
            answer += Math.ceil((double) (n - before + 1) / (w * 2 + 1));
        }

        return answer;
    }
}