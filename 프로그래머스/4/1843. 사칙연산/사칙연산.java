import java.util.*;

class Solution {
    public int solution(String arr[]) {
        // 배열에 숫자들을 넣는다.
        int[] num = getNumList(arr);
        int[] operator = getOperatorList(arr);
        // 숫자 수 만큼의 2차원 배열을 만든다.
        int[][] maxDp = new int[num.length][num.length];
        int[][] minDp = new int[num.length][num.length];
        // dnc를 진행한다.
        for (int i = 0; i < num.length; i++) {
            maxDp[i][i] = num[i];
            minDp[i][i] = num[i];
        }
        
        for (int step = 1; step < num.length; step++) {
            for (int i = 0; i < num.length - step; i++) {
                int j = i + step;
                maxDp[i][j] = -2100000000;
                minDp[i][j] = 2100000000;
                for (int k = i; k < j; k++) {
                    maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + operator[k] * maxDp[k + 1][j]);
                    maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + operator[k] * minDp[k + 1][j]);
                    minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + operator[k] * maxDp[k + 1][j]);
                    minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + operator[k] * minDp[k + 1][j]);
                }
                    
            }
        }
        
        return maxDp[0][num.length - 1];
    }
    
    private int[] getOperatorList(String[] arr) {
        int[] operator = new int[arr.length / 2];
        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i].equals("-"))
                operator[i / 2] = -1;
            else
                operator[i / 2] = 1;
        }
        return operator;
    }
    
    private int[] getNumList(String[] arr) {
        int[] num = new int[(arr.length + 1) / 2];
        for (int i = 0; i < arr.length; i += 2)
            num[i / 2] = Integer.parseInt(arr[i]);
        
        return num;
    }
}
