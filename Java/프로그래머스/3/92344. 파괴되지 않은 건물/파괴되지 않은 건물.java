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
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    if (sum[i][j] >= 0)
                        System.out.print(" ");    
                    System.out.print(sum[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("-------------------------");
        }
        
                for (int j = 0; j < sum[0].length; j++) { // 세로 방향 부분합 계산
            int prefix = sum[0][j];
            for (int i = 1; i < sum.length; i++) {
                sum[i][j] += prefix;
                prefix = sum[i][j];
            }
        }
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    if (sum[i][j] > 0)
                        System.out.print(" ");    
                    System.out.print(sum[i][j] + " ");
                }
                System.out.println("");
            }
        System.out.println("-------------------------");
        int answer = 0;
        
        for (int i = 0; i < sum.length; i++) { // 가로 방향 부분합 계산
            int prefix = sum[i][0];
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] += prefix;
                prefix = sum[i][j];
            }
        }
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    if (sum[i][j] > 0)
                        System.out.print(" ");    
                    System.out.print(sum[i][j] + " ");
                }
                System.out.println("");
            }
        System.out.println("-------------------------");

        
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