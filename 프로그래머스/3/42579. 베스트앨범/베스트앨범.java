import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 장르 별 노래 재생 총 횟수
        HashMap<String, Integer> count = new HashMap<>();
        // 장르 별 개별 재생 횟수
        HashMap<String, HashMap<Integer, Integer>> each = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!count.containsKey(genres[i])) {
                HashMap<Integer, Integer> data = new HashMap<>();
                data.put(i, plays[i]);
                count.put(genres[i], plays[i]);
                each.put(genres[i], data);
            } else {
                count.put(genres[i], count.get(genres[i]) + plays[i]);
                each.get(genres[i]).put(i, plays[i]);
            }
        }
        
        List<String> keySet = new ArrayList(count.keySet());
        Collections.sort(keySet, (s1, s2) -> count.get(s2) - count.get(s1));
        
        for (String key : keySet) {
            HashMap<Integer, Integer> data = each.get(key);
            List<Integer> eachKey = new ArrayList(data.keySet());
            
            Collections.sort(eachKey, (s1, s2) -> data.get(s2) - data.get(s1));
            
            answer.add(eachKey.get(0));
            if (eachKey.size() > 1) {
                answer.add(eachKey.get(1));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}