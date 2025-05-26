import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] stones, int k) {
        int low = 0, high = 200000000;
        int answer = -1;
        
        while (low < high) {
            int mid = (low + high) / 2;
            // System.out.println("low = " + low + " high = " + high + " mid = " + mid);
            if (ableToGo(stones, k, mid)) {
                answer = mid;
                // System.out.println("answer = " + answer);
                low = mid + 1;
            } else {
                high = mid;
            }
            
        }
        
        return answer;
    }
    
    private boolean ableToGo(int[] stones, int k, int cnt) {
        int holeCnt = 0, seqHoleCnt = 0;
        for (int stone : stones) {
            if (stone < cnt)
                holeCnt++;
            else
                holeCnt = 0;
            seqHoleCnt = Math.max(seqHoleCnt, holeCnt);
        }
        return seqHoleCnt < k;
    }
}

/*
1. 가장 큰 값을 가진 돌을 선택
2. 건널 수 있는 숫자를 이진탐색으로 검색
3. 건널 수 없다면 high = mid - 1
4. 건널 수 있다면 low = mid + 1
*/