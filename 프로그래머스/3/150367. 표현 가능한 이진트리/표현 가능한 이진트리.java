import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = 1;
        }
        
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            // 비트맵 길이 계산 (최대 레벨 결정)
            int level = getTreeLevel(number);
            // 비트맵 계산
            int[] bitMap = getBitMap(level, number);
            // 노드 탐색
            for (int nodeIdx = 1; nodeIdx < bitMap.length; nodeIdx++) {
                if (bitMap[nodeIdx] == 0)
                    continue;
                // 노드 레벨 결정
                int nodeLevel = getNodeLevel(nodeIdx);
                // 부모 노드 결정
                int parentNode = getParentNode(nodeIdx, nodeLevel);
                if (parentNode < bitMap.length && bitMap[parentNode] == 0) {
                    answer[i] = 0;
                    break;
                }
            }
            // 이진트리가 아닌경우 -> 루트 노트와 연결되지 못한 리프노드가 존재하는 경우.
            // 내 부모 노드는 어떻게 판단? 밑에서 부터 레벨 1이라고 가정. 왼쪽 노드면, 노드 번호 + 레벨, 오른쪽 노드면, 노드 번호 - 레벨
            // 레벨은 어떻게 판단? 레벨의 시작 노드 == 2^(레벨 - 1) + 2 ^ 레벨 * n
            // 왼쪽, 오른쪽은 어떻게 판단? n이 홀수면 왼쪽 짝수면 오른쪽
            //           8
            //    4                 12
            //  2   6         10          14
            // 1 3 5 7     9    11    13    15
        }
        return answer;
    }
    
    private int getParentNode(int nodeIdx, int level) {
        int nodeOrder = (nodeIdx - (int)Math.pow(2, level - 1)) / (int)Math.pow(2, level);
        int onRight = nodeOrder % 2;
        if (onRight == 1)
            return nodeIdx - (int)Math.pow(2, level - 1);
        return nodeIdx + (int)Math.pow(2, level - 1);
    }
    
    private int getNodeLevel(int nodeIdx) {
        for (int level = 1; true; level++) {
            if ((nodeIdx - (int)Math.pow(2, level - 1)) % (int)Math.pow(2, level) == 0)
                return level;
        }
    }
    
    private int[] getBitMap(int level, long number) {
        int[] bitMap = new int[(int)Math.pow(2, level)];
        for (int idx = bitMap.length - 1; idx > 0; idx--) {
            bitMap[idx] = (int) number % 2;
            number /= 2;
        }
        return bitMap;
    }
    
    private int getTreeLevel(long number) {
        int length = 0;
        while (number > 0) {
            number /= 2;
            length++;
        }
        
        int level = 0;
        while (length > 0) {
            length /= 2;
            level++;
        }
        return level;
    }
}
              
              