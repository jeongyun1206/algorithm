class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] sum = new int[board.length + 1][board[0].length + 1];
        
        for (int[] s : skill) {
            if (s[0] == 1)
	            s[5] *= -1;
            sum[s[1]][s[2]] += s[5];
            sum[s[1]][s[4] + 1] += s[5] * -1;
            sum[s[3] + 1][s[2]] += s[5] * -1;
            sum[s[3] + 1][s[4] + 1] += s[5];
        }
        
				for (int j = 0; j < sum[0].length; j++) { // 세로 방향 부분합 계산
            for (int i = 1; i < sum.length; i++)
                sum[i][j] += sum[i - 1][j];
        }
        
        for (int i = 0; i < sum.length; i++) { // 가로 방향 부분합 계산
            for (int j = 1; j < sum[0].length; j++)
                sum[i][j] += sum[i][j - 1];
        }
        
        int answer = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += sum[i][j];
                if (board[i][j] >= 1)
                    answer++;
            }
        }
        
        return answer;
    }
}