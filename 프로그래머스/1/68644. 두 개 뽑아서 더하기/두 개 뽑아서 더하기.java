import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> numSet = new HashSet<>();
        
        int length = numbers.length;
        
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                numSet.add(numbers[i] + numbers[j]);
            }
        }
        
        return numSet.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}