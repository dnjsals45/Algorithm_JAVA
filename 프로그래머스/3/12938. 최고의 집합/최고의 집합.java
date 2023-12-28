class Solution {
    /**
    *   s < n -> 최고의 집합이 존재할 수 없음
    *   s = n -> 모든 원소가 1인 경우밖에 존재하지 않음
    *   s > n -> 경우의 수를 모두 따져야 하나?
    *   곱이 최대려면 평균값에 근접한 수들의 집합이 가장 크지 않을까?
    **/
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (s < n) {
            return new int[]{-1};
        } else if (s == n) {
            for (int i = 0; i < n; i++) {
                answer[i] = 1;
            }
        } else {
            if (s % n == 0) {
                for (int i = 0; i < n; i++) {
                    answer[i] = s / n;
                }
            } else {
                int quotient = s / n;
                int remainder = s % n;
                for (int i = 0; i < n; i++) {
                    answer[i] = quotient;
                }
                for (int i = n - remainder; i < n; i++) {
                    answer[i]++;
                }
            }
        }       

        return answer;
    }
}