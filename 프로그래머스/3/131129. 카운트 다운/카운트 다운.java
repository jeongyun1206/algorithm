import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] throwCount = new int[target + 1];
        int[] singleCount = new int[target + 1];
        
        for (int point = 1; point <= target; point++) {
            int minThrow = 100000, maxSingle = 0;
            // 불
            int bullPoint = 50;
            if (point - bullPoint >= 0) {
                if (throwCount[point - bullPoint] + 1 < minThrow) {
                    minThrow = throwCount[point - bullPoint] + 1;
                    maxSingle = singleCount[point - bullPoint] + 1;
                } else if (throwCount[point - bullPoint] + 1 == minThrow) {
                    maxSingle = Math.max(maxSingle, singleCount[point - 50] + 1);
                }
            }
            for (int singlePoint = 1; singlePoint <= 20; singlePoint++) {
                // 싱글
                if (point - singlePoint >= 0) {
                    if (throwCount[point - singlePoint] + 1 < minThrow) {
                        minThrow = throwCount[point - singlePoint] + 1;
                        maxSingle = singleCount[point - singlePoint] + 1;
                    } else if (throwCount[point - singlePoint] + 1 == minThrow) {
                        maxSingle = Math.max(maxSingle, singleCount[point - singlePoint] + 1);
                    }
                }
                // 더블
                int doublePoint = singlePoint * 2;
                if (point - doublePoint >= 0) {
                    if (throwCount[point - doublePoint] + 1 < minThrow) {
                        minThrow = throwCount[point - doublePoint] + 1;
                        maxSingle = singleCount[point - doublePoint];
                    } else if (throwCount[point - doublePoint] + 1 == minThrow) {
                        maxSingle = Math.max(maxSingle, singleCount[point - doublePoint]);
                    }
                }
                // 트리플    
                int triplePoint = singlePoint * 3;
                if (point - triplePoint >= 0) {
                    if (throwCount[point - triplePoint] + 1 < minThrow) {
                        minThrow = throwCount[point - triplePoint] + 1;
                        maxSingle = singleCount[point - triplePoint];
                    } else if (throwCount[point - triplePoint] + 1 == minThrow) {
                        maxSingle = Math.max(maxSingle, singleCount[point - triplePoint]);
                    }
                }
            }
            throwCount[point] = minThrow;
            singleCount[point] = maxSingle;
        }
        // 1~20 싱글, 더블, 트리플, 50 불 총 61개의 경우의 수
        // 가장 작게 던지면서 target에 도달
        // 가장 작게 던지는 경우 중에서 싱글 + 불이 최대한 많도록.
        
        // for (int i = 0; i <= target; i++) {
        //     System.out.println("i = " + i + "\t throw = " + throwCount[i] + "\t single = " + singleCount[i]);
        // }
        
        int[] answer = new int[2];
        answer[0] = throwCount[target];
        answer[1] = singleCount[target];
        return answer;
    }
}
/*
point   0   1   2   3   4   5   6   7   8   9   10
throw   0   1   
sigle   0   1

*/