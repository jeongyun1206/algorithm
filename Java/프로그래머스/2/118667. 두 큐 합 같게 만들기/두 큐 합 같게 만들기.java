import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1Sum = 0, totalSum = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]); q2.add(queue2[i]);
            q1Sum += queue1[i]; totalSum += queue1[i] + queue2[i];
        }
        
        if (totalSum % 2 == 1)
            return -1;
        
        int answer = 0;
        while (q1Sum != totalSum / 2) {
            if (q1Sum < totalSum / 2) {
                q1Sum += q2.peek();
                q1.add(q2.poll());
            }
            else {
                q1Sum -= q1.peek();
                q2.add(q1.poll());
            }
            if (answer > (queue1.length + queue2.length) * 2)
                return -1;
            answer++;
        }        
        return answer;
    }    
}