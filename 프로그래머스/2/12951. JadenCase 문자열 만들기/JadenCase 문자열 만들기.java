class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;

        for (char c : s.toCharArray()) {
            if (isStart) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }

            isStart = (c == ' ');
        }

        return sb.toString();
    }
}