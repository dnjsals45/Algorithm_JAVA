import java.util.*;

class Solution {
    // 함수들간 연립방정식의 해를 구함
    // 정수로만 구성된 교차점을 구하고 별을 그림
    // 별을 구하기 위해서는 가장 큰, 작은 X,Y 좌표 필요
    public String[] solution(int[][] line) {
        int length = line.length;
        List<long[]> list = new ArrayList<>();
        
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                long[] result = solve(line[i], line[j]);
                if (result == null) continue;
                list.add(result);                               
            }
        }
        
        // 최대, 최소 X Y 범위 찾기
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        
        for (long[] arr : list) {
            minX = Math.min(minX, arr[0]);
            maxX = Math.max(maxX, arr[0]);
            minY = Math.min(minY, arr[1]);
            maxY = Math.max(maxY, arr[1]);
        }
        
        // 별을 찍기 위한 기본 좌표 구성
        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        
        char[][] charArr = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                charArr[i][j] = '.';
            }
        }
        
        // 만들어진 char[][] 배열에 별 찍기
        // 실제 좌표는 음수가 포함되기도 하지만, charArr은 0부터 시작 -> 교정 필요
        // X 좌표는 현재값에서 최소값을 빼면 x축 이동 가능
        // Y 좌표는 좌표상으로는 위로 올라가지만, 실제 배열 인덱스상으로는 아래로 내려감
        // 따라서 최대값에서 현재 값을 빼서 뒤집어줌
        for (long[] arr : list) {
            int x = (int)(arr[0] - minX);
            int y = (int)(maxY - arr[1]);
            charArr[y][x] = '*';
        }
        
        // char[][] -> String[]
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(charArr[i]);
        }
        
        return answer;
    }
    
    // Ax + By + C = 0 와 Dx + Ey + F = 0의 해를 구함
    // x = (BF - CE) / (AE - BD)
    // y = (CD - AF) / (AE - BD)
    public long[] solve(int[] line1, int[] line2) {
        long A = line1[0], B = line1[1], C = line1[2];
        long D = line2[0], E = line2[1], F = line2[2];
        
        long div = A * E - B * D;
        if (div == 0) {
            return null;
        }
        
        long numeratorX = B * F - C * E;
        long numeratorY = C * D - A * F;
        
        if (numeratorX % div != 0 || numeratorY % div != 0) {
            return null;
        }
        
        return new long[]{numeratorX / div, numeratorY / div};
    }
}