// 속한노래 재생순 -> 장르 재생순 -> 고유번호순
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> contain = new HashMap<>();
        Map<String, Map<Integer, Integer>> genreMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            contain.put(genres[i], contain.getOrDefault(genres[i], 0) + plays[i]);

            if (!genreMap.containsKey(genres[i])) {
               genreMap.put(genres[i], new HashMap<>());
            }
            
            genreMap.get(genres[i]).put(i, plays[i]);
        }
        
        List<String> containKeySet = new ArrayList<>(contain.keySet());
        
        containKeySet.sort((o1, o2) -> contain.get(o2).compareTo(contain.get(o1)));
        
        for (String key : containKeySet) {
            Map<Integer, Integer> data = genreMap.get(key);
            List<Integer> dataKeySet = new ArrayList<>(data.keySet());
            
            dataKeySet.sort((o1, o2) -> {
                if (!data.get(o1).equals(data.get(o2))) {
                    return data.get(o2) - data.get(o1);
                }
                return o1 - o2;
            });
            
            answer.add(dataKeySet.get(0));
            if (dataKeySet.size() >= 2) {
                answer.add(dataKeySet.get(1));
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}