import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for (int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int target = command[2];
            
            int[] cut = new int[end - start + 1];
            for (int i = 0; i < cut.length; i++) {
                cut[i] = array[start - 1 + i];
            }
            Arrays.sort(cut);
            
            answer.add(cut[target - 1]);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}