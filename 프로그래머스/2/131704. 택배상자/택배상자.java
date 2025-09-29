import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int current = 1;
        int count = 0;
        
        for (int target : order) {
            // 스택 맨위에 원하는 상자가 있으면 처리
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                count++;
            }
            // 메인 벨트에서 원하는 상자가 나올 때까지 스택에 저장
            else {
                // current부터 target까지 메인 벨트에서 뽑아내기
                while (current <= order.length && current != target) {
                    stack.push(current++);
                }
                
                // 원하는 상자를 찾았으면 처리
                if (current == target) {
                    current++;
                    count++;
                }
                // 스택 맨위에 원하는 상자가 있는지 다시 확인
                else if (!stack.isEmpty() && stack.peek() == target) {
                    stack.pop();
                    count++;
                }
                // 더 이상 처리할 수 없음
                else {
                    break;
                }
            }
        }
        
        return count;
    }
}