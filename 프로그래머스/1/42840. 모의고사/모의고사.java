import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) answer1++;
            if (answers[i] == student2[i % student2.length]) answer2++;
            if (answers[i] == student3[i % student3.length]) answer3++;
        }
        
        List<Integer> result = new ArrayList<>();
        int max = Math.max(answer1, Math.max(answer2, answer3));
        
        if (answer1 == max) result.add(1);
        if (answer2 == max) result.add(2);
        if (answer3 == max) result.add(3);
            
        return result.stream().mapToInt(i -> i).toArray();
    }
}