import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.replace("{", " ").replace("}", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b) -> {return a.length() - b.length();});
        List<String> list = new ArrayList<>();
        int[] answer = new int[arr.length];
        
        int index = 0;
        
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (!list.contains(s2)) {
                    list.add(s2);
                    answer[index] = Integer.parseInt(s2);
                    index++;
                }
            }
        }
        
        return answer;
    }
}