import java.util.*;

class Solution {
    class Node {
        int idx;
        Node prev, next;
        boolean removed;
        
        Node (int idx) {
            this.idx = idx;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        
        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
            nodes[i + 1].prev = nodes[i];
        }
        
        Node now = nodes[k];
        Stack<Node> stack = new Stack<>();
        
        for (String c : cmd) {
            char operation = c.charAt(0);
            
            if (operation == 'U') {
                int cnt = Integer.parseInt(c.split(" ")[1]);
                for (int i = 0; i < cnt; i++) {
                    now = now.prev;
                }
            } else if (operation == 'D') {
                int cnt = Integer.parseInt(c.split(" ")[1]);
                for (int i = 0; i < cnt; i++) {
                    now = now.next;
                }
            } else if (operation == 'C') {
                stack.push(now);
                now.removed = true;
                
                Node next = now.next;
                Node prev = now.prev;
                
                if (next != null) next.prev = prev;
                if (prev != null) prev.next = next;
                
                now = (next != null) ? next : prev;
            } else if (operation == 'Z') {
                Node restored = stack.pop();
                restored.removed = false;
                
                Node next = restored.next;
                Node prev = restored.prev;
                
                if (next != null) next.prev = restored;
                if (prev != null) prev.next = restored;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nodes[i].removed ? "X" : "O");
        }
        return sb.toString();
    }
}