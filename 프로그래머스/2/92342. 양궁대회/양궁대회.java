class Solution {
    private static int max;
    private static int[] answer = {-1};
    public int[] solution(int n, int[] info) {
        int[] arr = new int[11];
        
        solve(0, n, info, arr);
        
        return answer;
    }
    
    public void solve(int idx, int arrows, int[] info, int[] arr) {
        if (idx == 11) {
            if (arrows > 0) {
                arr[10] = arrows;
            }
            
            int diff = calculate(arr, info);
            
            if (diff > 0) {
                if (diff > max) {
                    max = diff;
                    answer = arr.clone();
                } else if (diff == max) {
                    if (compareLowScore(arr, answer)) {
                        answer = arr.clone();
                    }
                }
            }
            
            arr[10] = 0;
            return;
        }        
        
        int need = info[idx] + 1;
        if (arrows >= need) {
            arr[idx] = need;
            solve(idx + 1, arrows - need, info, arr);
            arr[idx] = 0;
        }
        
        solve(idx + 1, arrows, info, arr);
    }
    
    public int calculate(int[] a, int[] b) {
        int score = 0;
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0 && b[i] == 0) {
                continue;
            }
        
            if (a[i] > b[i]) {
                score += (10 - i);
            } else {
                score -= (10 - i);
            }
        }
        
        return score;
    }
    
    public boolean compareLowScore(int[] a, int[] b) {
        for (int i = 10; i >= 0; i--) {
            if (a[i] > b[i]) {
                return true;
            } else if (a[i] < b[i]) {
                return false;
            }
        }
        
        return false;
    }
}