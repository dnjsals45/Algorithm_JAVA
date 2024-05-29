import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
                
                int result = head1.toUpperCase().compareTo(head2.toUpperCase());
                
                if (result == 0) {
                    result = convert(o1.substring(head1.length())) - convert(o2.substring(head2.length()));
                }
                
                return result;
            }
        });
        
        return files;
    }
    
    public int convert(String str) {
        String result = "";
        
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) && result.length() <= 5) {
                result += c;
            } else {
                break;
            }
        }
        
        return Integer.parseInt(result);
    }
}