import java.util.*;
import java.util.stream.*;

class Solution {
    private final int idx = 0;
    private final int cnt = 1;
    
    public int solution(int[] a) {
        int[][] numInfo = new int[a.length + 1][2];
        for (int i = 0; i < a.length; i++) numInfo[i][idx] = -1;
        
        for (int curIdx = 0; curIdx < a.length; curIdx++) {
            int curNum = a[curIdx];
            
            if (numInfo[curNum][idx] < curIdx - 1 && a[curIdx - 1] != curNum) { // 왼쪽 선택 확인
                numInfo[curNum][idx] = curIdx;
                numInfo[curNum][cnt]++;
            } 
            else if (curIdx + 1 < a.length && a[curIdx + 1] != curNum) { // 오른쪽 선택 확인
                numInfo[curNum][idx] = curIdx + 1;
                numInfo[curNum][cnt]++;
            }
        }
        
        // for (int i = 0; i < a.length + 1; i++) {
        //     System.out.println("i = " + i + " idx = " + numInfo[i][idx] + " cnt = " + numInfo[i][cnt]);
        // }
        
        int max = 0;
        for (int i = 0; i < numInfo.length; i++) {
            max = Math.max(max, numInfo[i][cnt]);
        }
        
        return max * 2;
    }
}


/*
스타 수열 : 2개씩 끊어서, 서로 다른 숫자 2개씩, 공통되는 숫자 1개가 존재하도록.

1. 선형 탐색 하면서 해당 숫자가 짝지을 수 있는 숫자가 있는지 확인.
2. 선택 불가능한 숫자의 맨 오른쪽을 idx에 표시

선택 알고리즘
1. 자신의 idx값을 확인
2. 왼쪽, 오른쪽 순으로 선택.
3. idx값 갱신.
    왼쪽 선택이면 자기 자신.
    오른쪽 선택이면 + 1.

0 1 2 3 4 5
5,2,3,3,5,3

    idx cnt
0   -1  0
1   -1  0
2   1   1
3   4   2
4   -1  0
5   4   2

*/