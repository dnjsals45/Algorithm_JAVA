import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(0) == 'I') {
                int data = Integer.parseInt(operations[i].split(" ")[1]);
                minQueue.add(data);
                maxQueue.add(data);
            } else if (!maxQueue.isEmpty() && operations[i].equals("D 1")) {
                minQueue.remove(maxQueue.poll());
            } else if (!minQueue.isEmpty() && operations[i].equals("D -1")) {
                maxQueue.remove(minQueue.poll());
            }
        }
        
        return minQueue.isEmpty() ? new int[] {0, 0} : new int[] {maxQueue.poll(), minQueue.poll()};
    }
}