import java.util.*;

class Solution {
    // 무조건 자기보다 큰 원판 위로만 올라갈 수 있음
    // LIFO 방식이므로 3개의 스택을 사용하는 방식으로 생각
    // st1 -> st3 으로 모든 원판을 옮겨야 함
    // 우선 정순/역순으로 가능한 모든 조건을 확인하고 그에 맞춰 이동하도록 설정
//     public int[][] solution(int n) {
//         Stack<Integer> st1 = new Stack<>();
//         Stack<Integer> st2 = new Stack<>();
//         Stack<Integer> st3 = new Stack<>();
        
//         for (int i = n; i > 0; i--) {
//             st1.push(i);
//         }
        
//         List<int[]> list = new ArrayList<>();
        
//         while (st3.size() != n) {
//         if (possible(st1, st2)) {
//             int m = st1.pop();
//             st2.push(m);
//             list.add(new int[]{1, 2});
//         } else if (possible(st1, st3)) {
//             int m = st1.pop();
//             st3.push(m);
//             list.add(new int[]{1, 3});
//         } else if (possible(st2, st3)) {
//             int m = st2.pop();
//             st3.push(m);
//             list.add(new int[]{2, 3});
//         } else if (possible(st2, st1)) {
//             int m = st2.pop();
//             st1.push(m);
//             list.add(new int[]{2, 1});
//         } else if (possible(st3, st1)) {
//             int m = st3.pop();
//             st1.push(m);
//             list.add(new int[]{3, 1});
//         } else if (possible(st3, st2)) {
//             int m = st3.pop();
//             st2.push(m);
//             list.add(new int[]{3, 2});
//         }
//     }
        
//         return list.toArray(new int[list.size()][]);
//     }
    
//     public boolean possible(Stack<Integer> s1, Stack<Integer> s2) {
//         if (s1.size() == 0) return false;
//         if (s2.size() == 0) return true;
        
//         if (s1.peek() < s2.peek()) return true;
//         else return false;
//     }
    
    // 계속해서 모든 조건을 채우기보다는 분할정복으로도 가능
    // ex. 1 -> 3으로 n개의 원판을 옮기는 과정에서
    // ex. 1 -> 2로 n-1개의 원판을 옮기고
    // ex. 1 -> 3으로 가장 큰 n 원판을 옮김
    // ex. 2 -> 3으로 n-1개의 원판을 옮기는 작은 문제로 변화
    // ex. 이 작은 문제에서는 2 -> 1로 n-2개를 옮기고, 2 -> 3으로 n-1크기 원판을 옮기는 식으로 변경됨
    
    public int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();
        
        solve(n, 1, 3, 2, list);
        
        return list.toArray(new int[list.size()][]);
    }
    
    public void solve(int size, int from, int to, int sub, List<int[]> list) {
        if (size == 1) {
            list.add(new int[]{from, to});
            return;
        }
        
        solve(size - 1, from, sub, to, list);
        
        list.add(new int[]{from, to});
        
        solve(size - 1, sub, to, from, list);
    }
}