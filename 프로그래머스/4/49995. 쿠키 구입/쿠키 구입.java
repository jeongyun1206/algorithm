class Solution {
    public int solution(int[] cookie) {
        // i, j 번을 선택한 경우에 몇개의 쿠키가 들어가는지를 담는 2차원 배열 생성
        int[][] cookieSum = getCookieSum(cookie);
        // i, m, r의 경우의 수를 탐색
        int answer = 0;
        for (int i = 0; i < cookie.length; i++) {
            for (int m = i; m < cookie.length; m++) {
                if (cookieSum[i][m] <= answer || cookieSum[i][m] > cookieSum[0][cookie.length - 1] / 2)
                    continue;
                for (int r = m + 1; r < cookie.length; r++) {
                    if (cookieSum[i][m] == cookieSum[m+1][r]) {
                        answer = Math.max(answer, cookieSum[i][m]);
                        break;
                    }
                    // i~m 보다 m~r이 더 큰 경우가 나오는 순간 탐색 중지하고 다음 단계로
                    else if (cookieSum[i][m] < cookieSum[m+1][r])
                        break;
                }
            }
        }
        return answer;
    }
    
    private int[][] getCookieSum(int[] cookie) {
        int[][] cookieSum = new int[cookie.length][cookie.length];
        for (int i = 0; i < cookie.length; i++) {
            for (int j = i; j < cookie.length; j++) {
                if (i == j)
                    cookieSum[i][j] = cookie[i];
                else
                    cookieSum[i][j] = cookieSum[i][j - 1] + cookie[j];
            }
        }
        // for (int i = 0; i < cookie.length; i++) {
        //     for (int j = 0; j < cookie.length; j++) {
        //         System.out.print(cookieSum[i][j] + "\t");
        //     }
        //     System.out.println("");
        // }
        return cookieSum;
    }
    //  0   1   2   3
    // 01   2   4   7
    // 10   1   3   6
    // 20   0   2   5
    // 30   0   0   3
    // cookieSum[i][i] = cookie[i]
    // cookieSum[i][j] = cookieSum[i][j - 1] + cookie[j]
}