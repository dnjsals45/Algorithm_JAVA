class Solution {
    // 조건에서 두 수 모두 0 초과이므로 0으로 나누는 문제 생각 x
    // Math.floor을 사용하지 않고 int 형으로 캐스팅만해도 자동으로 내림 처리가 된다.
    public int solution(int num1, int num2) {
        double quotient = (double) num1 / num2;
        
        return (int) (quotient * 1000);
    }
}