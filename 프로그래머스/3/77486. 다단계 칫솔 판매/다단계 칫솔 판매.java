import java.util.HashMap;

class Solution {
    HashMap<String, Integer> sellerId = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) sellerId.put(enroll[i], i);
        
        int[] referralId = new int[enroll.length];
        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-"))
                referralId[i] = -1;
            else
                referralId[i] = sellerId.get(referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            int curSeller = sellerId.get(seller[i]);
            int profit = amount[i] * 100;
            
            while (curSeller != -1) {
                answer[curSeller] += profit - profit / 10;
                profit /= 10;
                curSeller = referralId[curSeller];
            }
        }
        
        return answer;
    }
}