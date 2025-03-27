import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        String[] numString = br.readLine().split(" ");

        for (String s : numString) {
            int num = Integer.parseInt(s);
            if (isPrime(num)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
