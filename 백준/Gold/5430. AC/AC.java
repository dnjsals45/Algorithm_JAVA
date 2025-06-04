import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        Deque<Integer> deq;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            deq = new ArrayDeque<>();
            sb = new StringBuilder();
            String func = br.readLine();
            br.readLine();
            String nums = br.readLine();
            nums = nums.substring(1, nums.length() - 1);
            if (!nums.isEmpty()) {
                String[] numArr = nums.split(",");
                for (String nu : numArr) {
                    deq.add(Integer.parseInt(nu));
                }
            }

            boolean reverse = false;
            boolean error = false;
            for(char c : func.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (deq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (!reverse) {
                        deq.pollFirst();
                    } else {
                        deq.pollLast();
                    }
                }
            }

            if (error) {
                sb.append("error");
            } else {
                sb.append("[");
                if (!reverse) {
                    while (!deq.isEmpty()) {
                        sb.append(deq.pollFirst());
                        if (!deq.isEmpty()) {
                            sb.append(",");
                        }
                    }
                } else {
                    while (!deq.isEmpty()) {
                        sb.append(deq.pollLast());
                        if (!deq.isEmpty()) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]");
            }

            System.out.println(sb);
        }
    }
}
