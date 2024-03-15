import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        
        for (int i : works) pq.offer(i);
        int maxWork = 0;
        while (n > 0) {
            maxWork = pq.poll();
            if (maxWork == 0) {
                pq.offer(maxWork);
                break;
            }
            maxWork--;
            pq.offer(maxWork);
            n--;
        }
        long answer = 0;
        for (int i : pq) {
            // System.out.print(i + " ");
            answer += i * i;
        }
        return answer;
    }    
}