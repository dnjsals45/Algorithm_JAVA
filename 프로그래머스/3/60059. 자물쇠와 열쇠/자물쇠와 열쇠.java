class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int point = key.length - 1;
        for (int i = 0; i < point + lock.length; i++) {
            for (int j = 0; j < point + lock.length; j++) {
                // r = 0: 기본, r = 1: 90도 회전, r = 2: 180도 회전, r = 3: 270도 회전
                for (int r = 0; r < 4; r++) {
                    int[][] lockMap = new int[lock.length + point * 2][lock.length + point * 2];
                    for (int x = 0; x < lock.length; x++) {
                        for (int y = 0; y < lock.length; y++) {
                            lockMap[x + point][y + point] = lock[x][y];
                        }
                    }
                    match(lockMap, key, r, i, j);
                    if (check(lockMap, point, lock.length)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void match(int[][] lockMap, int[][] key, int r, int x, int y) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (r == 0) {
                    lockMap[x + i][y + j] += key[i][j];
                } else if (r == 1) {
                    lockMap[x + i][y + j] += key[j][key.length - i - 1];
                } else if (r == 2) {
                    lockMap[x + i][y + j] += key[key.length - i - 1][key.length - j - 1];
                } else if (r == 3) {
                    lockMap[x + i][y + j] += key[key.length - j - 1][i];
                }
            }
        }
    }
    
    public boolean check(int[][] lockMap, int point, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (lockMap[point + i][point + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}