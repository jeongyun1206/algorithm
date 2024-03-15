class Solution {
    public long solution(int n, int[] works) {
        int total = 0;
        for (int i : works) {
            total += i;
        }
        if (total <= n)
            return 0;
        
        int low = 0, high = 1000000, mid;
        int averageWork = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (workPossible(mid, works, n) == 1) {
                averageWork = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        System.out.println(averageWork);
        
        for (int i = 0; i < works.length; i++) {
            if (works[i] > averageWork) {
                n -= works[i] - averageWork;
                works[i] = averageWork;
            }
        }
        
        for (int i = 0; i < works.length; i++) {
            if (n == 0)
                break;
            if (works[i] == averageWork) {
                works[i]--;
                n--;
            }
        }
        
        long answer = 0;
        for (int i : works) {
            answer += i * i;
        }
        return answer;
    }
    
    private int workPossible(int mid, int[] works, int n) {
        int workTime = 0;
        
        for (int w : works) {
            if (w > mid) {
                workTime += w - mid;
            }
        }
        
        if (workTime > n)
            return 0;
        return 1;
    }
}