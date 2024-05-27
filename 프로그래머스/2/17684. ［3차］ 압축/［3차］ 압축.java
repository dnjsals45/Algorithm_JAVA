import java.util.*;

class Solution {
    int index = 1;
    int now = 0;
    Map<String, Integer> dictionary;
    List<Integer> answer;
    public int[] solution(String msg) {
        answer = new ArrayList<>();
        dictionary = new HashMap<>();
        String key = "";
        
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(Character.toString(c), index++);
        }
        
        for (int i = now; i <= msg.length(); i++) {
            key = findKey(msg);
            dictionary.put(key, index++);
            i = now;
        }
        
        System.out.println(key);

        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public String findKey(String msg) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        for (int i = now; i < msg.length(); i++) {
            sb.append(msg.charAt(i));
            if (dictionary.containsKey(sb.toString())) {
                num = dictionary.get(sb.toString());
                now++;
            } else {
                answer.add(num);
                break;
            }
        }
        
        if (dictionary.containsKey(sb.toString())) {
            answer.add(dictionary.get(sb.toString()));
        }
        
        return sb.toString();
    }
}