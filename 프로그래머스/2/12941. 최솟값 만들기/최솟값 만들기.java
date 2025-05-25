import java.util.*;

class Solution
{
    static List<Integer> a;
    static List<Integer> b;
    public int solution(int []A, int []B)
    {
        a = new ArrayList<>();
        b = new ArrayList<>();
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }
        
        Collections.sort(a);
        Collections.sort(b, Comparator.reverseOrder());
        
        for (int i = 0; i < A.length; i++) {
            sum += (a.get(i) * b.get(i));
        }
        
        
        return sum;
    }
}