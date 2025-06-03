import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] schedules = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            schedules[i][0] = start;
            schedules[i][1] = end;
        }

        Arrays.sort(schedules, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int lastEndTime = 0;

        for (int i = 0; i < N; ++i) {
            if (lastEndTime <= schedules[i][0]){
                lastEndTime = schedules[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
