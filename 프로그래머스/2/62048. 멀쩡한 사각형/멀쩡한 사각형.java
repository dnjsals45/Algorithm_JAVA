import java.util.*;

class Solution {
    // 직사각형에서 만들 수 있던 정사각형 개수 = 가로 x 세로
    // 기울기를 구해서 x축, y축과 만나는 점의 개수를 구한다
    // 하지만 그림으로 생각해보면 결국 직선과 x축이 만나는 점의 개수 = 가로의 길이
    // 직선과 y축이 만나는 점의 개수 = 세로의 길이
    // 두 개가 중복으로 만나는 지점이 존재(꼭짓점과 맞닿을 때)
    // 가로의 길이 + 세로의 길이 - (꼭짓점과 맞닿는 개수)
    // 꼭짓점과 맞닿는 개수는 최대공약수와 동일하다.
    // 따라서 가로의 길이 + 세로의 길이 - (두 길이의 최대공약수) 가 정답이 된다.
    public long solution(int w, int h) {
        long max = (long) w * h;
        long impossible = w + h - gcd(w, h);
        
        return max - impossible;
    }
    
    private long gcd(long w, long h) {
        while (h != 0) {
            long tmp = h;
            h = w % h;
            w = tmp;
        }
        
        return w;
    }
}