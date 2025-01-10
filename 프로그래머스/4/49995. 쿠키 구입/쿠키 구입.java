class Solution {
    public int solution(int[] cookie) {
        // i, j 번을 선택한 경우에 몇개의 쿠키가 들어가는지를 담는 2차원 배열 생성
        int[][] cookieSum = getCookieSum(cookie);
        // i, m, r의 경우의 수를 탐색
        int answer = 0;
        for (int i = 0; i < cookie.length; i++) {
            for (int j = cookie.length - 1; j > i; j--) {
                if (cookieSum[i][j] / 2 < answer)
                    break;
                answer = Math.max(answer, binarySearch(i, j, cookieSum));
            }
        }
        return answer;
    }
    
    int binarySearch(int i, int j, int[][] cookieSum) {
        int low = i;
        int high = j;
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (cookieSum[i][mid] == cookieSum[mid + 1][j])
                return cookieSum[i][mid];
            else if (cookieSum[i][mid] < cookieSum[mid + 1][j])
                low = mid + 1;
            else
                high = mid;
        }
        return 0;
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
        return cookieSum;
    }
    //  0   1   2   3
    // 01   2   4   7
    // 10   1   3   6
    // 20   0   2   5
    // 30   0   0   3
    
}