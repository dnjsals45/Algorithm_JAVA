class Solution {
    // 최상단 조건부터 사용하면 (0 < angle && angle < 90) 과 같은 불필요한 이중 구문을 없앨 수 있음
    public int solution(int angle) {
        if (angle == 180) return 4;
        else if (angle > 90) return 3;
        else if (angle == 90) return 2;
        else if (angle > 0) return 1;
        
        return 0;
    }
}