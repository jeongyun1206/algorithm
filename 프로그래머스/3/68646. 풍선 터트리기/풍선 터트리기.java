import java.util.*;

class Solution {
    public int solution(int[] a) {
        // 1. 가장 작은 원소의 인덱스 탐색, leftmostIdx와 rightmostIdx를 해당 인덱스로 초기화
        // 2. 그 다음으로 작은 원소의 인덱스 탐색
        // 3. 2번에서 찾은 원소가 leftmostIdx보다 작으면 answer++ 하고 leftmostIdx 초기화, rightmostIdx보다 크면 answer++ 하고 rightmostIdx 초기화.
        // 4. 2번 반복
        
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < a.length; i++) index.put(a[i], i);
        
        Arrays.sort(a);
        
        int answer = 1, leftmostIdx = index.get(a[0]), rightmostIdx = index.get(a[0]);
        
        for (int i = 1; i < a.length; i++) {
            int curIdx = index.get(a[i]);
            if (curIdx < leftmostIdx) {
                leftmostIdx = curIdx;
                answer++;   
            } else if (curIdx > rightmostIdx) {
                rightmostIdx = curIdx;
                answer++;
            }
        }
        
        
        return answer;
    }
}