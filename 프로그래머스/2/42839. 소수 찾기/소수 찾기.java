// 17 -> 1, 7
// 1, 7, 17, 71
import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        Set<Integer> number = new HashSet<>();
        char[] numberArray = numbers.toCharArray();
        boolean[] visited = new boolean[numberArray.length];
        
        generateNumber(numberArray, visited, sb, number);
        
        for (int num : number) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void generateNumber(char[] numberArray, boolean[] visited, StringBuilder current, Set<Integer> number) {
       if (current.length() > 0) {
           number.add(Integer.parseInt(current.toString()));
       }
        
        for (int i = 0; i < numberArray.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.append(numberArray[i]);
                generateNumber(numberArray, visited, current, number);
                current.deleteCharAt(current.length() - 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}