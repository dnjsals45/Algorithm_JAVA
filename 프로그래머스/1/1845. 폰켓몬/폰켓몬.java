import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int size = nums.length / 2;
        
        for (int num : nums) {
            set.add(num);
        }
        
        return size >= set.size() ? set.size() : size;
    }
}