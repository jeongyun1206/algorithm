class Solution {
    public int solution(int[] money) {
        int[] moneySum0 = new int[money.length];
        int[] moneySum1 = new int[money.length];
        
        int answer1 = 0;
        int answer0 = 0;
        
        // 0번을 털지 않고 마지막을 털은 경우
        for (int i = 1; i < money.length; i++) {
            moneySum0[i] = Math.max(moneySum0[i - 1], moneySum1[i - 1]);
            moneySum1[i] = moneySum0[i - 1] + money[i];
        }
        answer0 = Math.max(moneySum0[money.length - 1], moneySum1[money.length - 1]);
        // 0번을 털고 마지막을 털지 않은 경우
        moneySum1[0] = money[0];
        for (int i = 1; i < money.length - 1; i++) {
            moneySum0[i] = Math.max(moneySum0[i - 1], moneySum1[i - 1]);
            moneySum1[i] = moneySum0[i - 1] + money[i];
        }
        answer1 = Math.max(moneySum0[money.length - 2], moneySum1[money.length - 2]);
        
        return Math.max(answer1, answer0);
    }
    
    // 돈 1 2 3 1
    // 
    // 털음max    moneySum[i][1] = moneySum[i - 1][0] + money[i];
    // 안털음max   moneuSum[i][0] = moneySum[i - 1][0] + money
}