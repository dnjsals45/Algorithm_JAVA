class Solution {
    public long solution(long n) {
        long answer = 0;
        int[] arr = new int[10];
        
        while (n != 0) {
            int num = (int) (n % 10);
            arr[num]++;
            n /= 10;
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) continue;
            for (int j = 0; j < arr[i]; j++) {
                answer *= 10;
                answer += i;
            }
        }
        
        return answer;
    }
}