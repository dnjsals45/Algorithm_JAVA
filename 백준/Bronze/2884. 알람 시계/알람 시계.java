import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int Hour = Integer.parseInt(st.nextToken());
        int Minute = Integer.parseInt(st.nextToken());

        if ((Minute - 45) < 0) {
            if (Hour == 0)
                Hour = 24;
            Hour = Hour - 1;
            Minute = 60 + (Minute - 45);
            sb.append(Hour).append(" ").append(Minute);
        } else {
            Minute = Minute - 45;
            sb.append(Hour).append(" ").append(Minute);
        }
        System.out.println(sb);
    }
}