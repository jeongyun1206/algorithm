class Solution {
    int[] dp;
    public int solution(int n, int[] money) {
        
        dp = new int[n + 1];
        
        dp[0] = 1;
        
        for (int coin : money) {
            for (int i = 1; i <= n; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[n] % 1000000007;
    }
}