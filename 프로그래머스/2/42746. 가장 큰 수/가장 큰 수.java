import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] data = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            data[i] = String.valueOf(numbers[i]);
        }
       
        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        if (data[0].equals("0")) {
            return "0";
        }
        
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
        }
        
        return sb.toString();
    }
}