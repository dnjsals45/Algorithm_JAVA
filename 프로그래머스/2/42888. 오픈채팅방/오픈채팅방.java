import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> msg = new HashMap<>();
        Map<String, String> nickname = new HashMap<>();
        
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");
        
        for (String s : record) {
            String[] str = s.split(" ");
            
            if (str.length == 3) {
                nickname.put(str[1], str[2]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        
        for (String s : record) {
            String[] str = s.split(" ");
            
            if (msg.containsKey(str[0])) {
                answer.add(nickname.get(str[1]) + msg.get(str[0]));
            }
        }
        
        return answer.toArray(new String[0]);
    }
}