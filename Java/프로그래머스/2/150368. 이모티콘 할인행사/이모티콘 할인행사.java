import java.util.Arrays;

class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discountRate = new int[emoticons.length];
        dfs(0, discountRate, users, emoticons);
        return answer;
    }
    
    private void dfs(int index, int[] discountRate, int[][] users, int[] emoticons) {
        if (index == emoticons.length) {
            updateAnswer(discountRate, users, emoticons);
            return ;
        }
        
        for (int i = 0; i <= 4; i++) {
            discountRate[index] = i * 10;
            dfs(index + 1, discountRate, users, emoticons);
        }
    }
    
    private void updateAnswer(int[] discountRate, int[][] users, int[] emoticons) {
        int subscription = 0, totalPrice = 0;
        
        for (int[] user : users) {
            int price = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (user[0] <= discountRate[i])
                    price += emoticons[i] * (100 - discountRate[i]) / 100;
            }
            
            if (price >= user[1])
                subscription++;
            else
                totalPrice += price;
        }
        
        if (subscription == answer[0]) {
            answer[1] = Math.max(answer[1], totalPrice);
        } else if (subscription > answer[0]) {
            answer[0] = subscription;
            answer[1] = totalPrice;
        }
    }
}