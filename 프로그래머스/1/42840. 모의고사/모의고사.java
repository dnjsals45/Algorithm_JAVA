import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == answer1[i % answer1.length]) count1++;
            if (answers[i] == answer2[i % answer2.length]) count2++;
            if (answers[i] == answer3[i % answer3.length]) count3++;
        }
        
        int max = Math.max(count1, Math.max(count2, count3));
        
        List<Integer> result = new ArrayList<>();
        
        if (count1 == max) result.add(1);
        if (count2 == max) result.add(2);
        if (count3 == max) result.add(3);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}