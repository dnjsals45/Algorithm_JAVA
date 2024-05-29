import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for (String str : record) {
            String[] log = str.replace("\"", " ").trim().split(" ");

            String command = log[0];
            String uid = log[1];
            if (command.equals("Enter")) {
                String nickname = log[2];
                map.put(uid, nickname);
                list.add(uid + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                list.add(uid + "님이 나갔습니다.");
            } else if (command.equals("Change")) {
                String nickname = log[2];
                map.put(uid, nickname);
            }
        }
        
        for (String line : list) {
            String uid = line.replace("\"", " ").trim().split(" ")[0].replace("님이", "");
            String nickname = map.get(uid);
            answer.add(line.replace(uid, nickname));
        }
        
        return answer.stream().toArray(String[]::new);
    }
}