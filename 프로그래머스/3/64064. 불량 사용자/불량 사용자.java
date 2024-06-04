import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        List<Set<String>> list = new ArrayList<>();
        Set<Set<String>> result = new HashSet<>();
        
        for (String ban : banned_id) {
            Set<String> tmp = new HashSet<>();
            for (String user : user_id) {
                if (checkBanList(ban, user)) {
                    tmp.add(user);
                }    
            }
            list.add(tmp);
        }
        
        dfs(0, new HashSet<>(), result, list);
        
        return result.size();
    }
    
    public boolean checkBanList(String ban, String user) {
        if (ban.length() != user.length()) {
            return false;
        }
        
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) != '*' && ban.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    public void dfs(int depth, Set<String> current, Set<Set<String>> result, List<Set<String>> list) {
        if (depth == list.size()) {
            result.add(new HashSet<>(current));
            return;
        }
        
        for (String user : list.get(depth)) {
            if (!current.contains(user)) {
                current.add(user);
                dfs(depth + 1, current, result, list);
                current.remove(user);
            }
        }
    }
}