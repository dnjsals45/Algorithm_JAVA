import java.util.*;
import java.io.*;

/**
 * a, b = 밑변, c = 대각변
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] numbers = line.split(" ");
            if (numbers.length != 3) {
                System.out.println("wrong");
                continue;
            }

            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            int c = Integer.parseInt(numbers[2]);

            // 마지막 줄은 0 0 0 이 들어온다
            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int[] sides = new int[]{a, b, c};
            Arrays.sort(sides);

            if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

    }
}