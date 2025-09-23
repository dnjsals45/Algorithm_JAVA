class Solution {
    public String solution(String[] seoul) {
        int pos = 0;
        for (String s : seoul) {
            pos++;
            if (s.equals("Kim")) break;
        }
        
        return "김서방은 " + (pos - 1) + "에 있다";
    }
}