class Solution {
    private final int MOD = 20170805;
    private final int RIGHT = 0;
    private final int DOWN = 1;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] availCnt = new int[m][n][2];
        
        availCnt[0][0][RIGHT] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) // 통행 금지
                    continue;
                
                int rightCnt = 0;
                if (j - 1 >= 0 && cityMap[i][j - 1] == 2) { // 왼쪽에서 오른쪽으로
                    rightCnt += availCnt[i][j - 1][RIGHT];
                } else if (j - 1 >= 0) {
                    rightCnt += availCnt[i][j - 1][DOWN];
                    rightCnt += availCnt[i][j - 1][RIGHT];
                }
                availCnt[i][j][RIGHT] += rightCnt % MOD;
                
                int downCnt = 0;
                if (i - 1 >= 0 && cityMap[i - 1][j] == 2) { // 위에서 아래로
                    downCnt += availCnt[i - 1][j][DOWN];
                } else if (i - 1 >= 0) {
                    downCnt += availCnt[i - 1][j][DOWN];
                    downCnt += availCnt[i - 1][j][RIGHT];
                }
                
                availCnt[i][j][DOWN] += downCnt % MOD;
            }
        }
        
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(cityMap[i][j] + " ( " + availCnt[i][j][RIGHT] + ", " + availCnt[i][j][DOWN] + " )\t");
        //     }
        //     System.out.println("");
        // }
        int answer = (availCnt[m - 1][n - 1][RIGHT] + availCnt[m - 1][n - 1][DOWN]) % MOD;
        return answer;
    }
    
    
}

/*
s   2   0   0   0   2
0   0   2   0   1   0
1   0   0   2   2   d

0   1   1
1   1
*/