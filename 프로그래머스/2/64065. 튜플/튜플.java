import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer[]> list = new ArrayList<>();
        
        s = s.substring(1, s.length() - 1);
        
        String[] sets = s.split("\\},\\{");
        
        for (String set : sets) {
            set = set.replace("{", "").replace("}", "");
            
            String[] numbers = set.split(",");
            Integer[] arr = new Integer[numbers.length];
            
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }
            
            list.add(arr);
        }
        
        Collections.sort(list, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return Integer.compare(o1.length, o2.length);
            }
        });
        
        List<Integer> result = new ArrayList<>();
        for (Integer[] arr : list) {
            for (Integer num : arr) {
                if (!result.contains(num)) {
                    result.add(num);
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}