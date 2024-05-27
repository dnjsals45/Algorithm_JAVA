import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String st = str1.substring(i, i + 2).toUpperCase();
            if (Character.isLetter(st.charAt(0)) && Character.isLetter(st.charAt(1))) {
                list1.add(st);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String st = str2.substring(i, i + 2).toUpperCase();
            if (Character.isLetter(st.charAt(0)) && Character.isLetter(st.charAt(1))) {
                list2.add(st);
            }
        }
        
        List<String> difList = new ArrayList<>(list1);
        
        for (String s : list2) {
            if (difList.contains(s)) {
                difList.remove(s);
            }
        }
        
        int common = list1.size() - difList.size();
        int combine = list2.size() + difList.size();
        
        if (combine == 0) {
            return 65536;
        }
        
        return (int) Math.floor(((double)common / combine) * 65536);
    }
}