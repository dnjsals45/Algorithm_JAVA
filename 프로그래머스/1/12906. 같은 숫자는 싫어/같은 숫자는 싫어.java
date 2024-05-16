import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty()) {
                st.push(arr[i]);
            } else {
                int top = st.peek();
                if (arr[i] == top) {
                    continue;
                } else {
                    st.push(arr[i]);
                }
            }
        }
        
        int size = st.size();
        int[] answer = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }
        
        
        return answer;
    }
}