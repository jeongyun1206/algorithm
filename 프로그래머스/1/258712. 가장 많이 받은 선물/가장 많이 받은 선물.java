import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> friendIndex = new HashMap<>();
        int[][] gift = new int[friends.length][friends.length];
        int[] giftIndex = new int[friends.length];
        
        for (int i = 0; i < friends.length; i++) friendIndex.put(friends[i], i);
        
        for (String g : gifts) {
            int give = friendIndex.get(g.split(" ")[0]);
            int take = friendIndex.get(g.split(" ")[1]);
            gift[give][take]++;
            giftIndex[give]++;
            giftIndex[take]--;
        }
        
        int[] finalGift = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (gift[i][j] > gift[j][i]) { // 선물 비교
                    finalGift[i]++;
                } else if (gift[i][j] == gift[j][i] && giftIndex[i] > giftIndex[j]) { // 선물 지수 비교
                    finalGift[i]++;
                }
            }
        }
        
        return Arrays.stream(finalGift)
            .max()
            .getAsInt();
    }
}

// 1. 두 사람이 선물 기록이 있다면 더 많이 준 사람이 받는다.
// 2. 기록이 없거나 수가 같다면, 선물지수가 더 큰사람이 받는다.
//     선물지수는 모두 준 수에서 받은 수를 뺀값
// 3. 가장 많이 받은 사람은 얼마나 받았는가?
    