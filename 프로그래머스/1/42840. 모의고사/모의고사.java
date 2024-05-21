import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) {
                score1++;
            }
            if (answers[i] == student2[i % student2.length]) {
                score2++;
            }
            if (answers[i] == student3[i % student3.length]) {
                score3++;
            }
        }
        
        int max = Math.max(score1, Math.max(score2, score3));
        
        if (score1 == max) {
            answer.add(1);
        }
        if (score2 == max) {
            answer.add(2);
        }
        if (score3 == max) {
            answer.add(3);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}