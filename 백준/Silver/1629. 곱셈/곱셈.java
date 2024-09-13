import java.util.*;
import java.io.*;

public class Main {
    static long C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    static long pow(long A, long B) {
        if (B == 1) {
            return A % C;
        }

        long temp = pow(A, B / 2);

//        (temp * temp * A) % C
//                = ((temp * temp % C) * A % C) % C
//                = (((temp % C) * (temp % C)) % C * A % C) % C
//                = ((temp * temp % C) % C * A % C) % C
//                = ((temp * temp % C) * A) % C
        if (B % 2 == 1) {
            return (temp * temp % C) * A % C;
        }

        return temp * temp % C;
    }
}
