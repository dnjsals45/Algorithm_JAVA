class Solution {
    public int solution(int num) {
        long convertNum = (long) num;
        int answer = 0;
        
        for (int i = 0; i < 500; i++) {
            if (convertNum == 1) break;
            
            answer++;
            
            if (convertNum % 2 == 0) {
                convertNum = convertNum / 2;
            } else {
                convertNum = convertNum * 3 + 1;
            }
        }
        
        return answer == 500 ? -1 : answer;
    }
}