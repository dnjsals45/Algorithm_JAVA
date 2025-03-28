import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Character> stack;

        for (int i = 0; i < N; i++) {
            boolean check = false;
            stack = new Stack<>();
            String str = br.readLine();

            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        check = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!check) {
                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
