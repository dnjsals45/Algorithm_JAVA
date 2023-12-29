import java.util.*;

class Solution {
    /**
    *   B팀 입장에서 최고의 전략이 무엇일까?
    *   상대의 높은 카드는 낮은 카드로 상대, 그 이외에는 차이가 가장 적게 나게 상대?
    *   정렬해서 그냥 단순 비교하는 것은?
    *   단순 비교하지 말고, B의 원소가 이길 수 있는 경우가 있는지를 전부 체크?
    *   테스트는 통과하지만 시간초과 발생 -> 어느 부분에서 시간을 단축시킬 수 있을까?
    *   2중 for문 사용 -> 시간초과
    **/
    public int solution(int[] A, int[] B) {
        int answer = 0;
        // A, B 둘다 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
       
        // B 입장에서 가장 큰 값이 A의 가장 작은 값보다 작다면 이길 수 있는 경우의 수가 존재하지 않음
        if (B[B.length - 1] < A[0])
            return 0;
        
        int indexB = B.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (B[indexB] > A[i]) {
                answer++;
                indexB--;
            }
        }
        
        return answer;
    }
}