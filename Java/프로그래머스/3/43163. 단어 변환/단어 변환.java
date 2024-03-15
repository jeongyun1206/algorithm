import java.util.*;

class Solution {
    int[][] wordsMatrix;
    int[] visited;
    String[] wordsArr;
    
    public int solution(String begin, String target, String[] words) {
        wordsArr = new String[words.length + 1];
        for (int i = 0; i < words.length; i++) wordsArr[i + 1] = words[i];
        wordsArr[0] = begin; // begin을 0번 idx에 위치시킨다.
        wordsMatrix = new int[wordsArr.length][];
        for (int i = 0; i < wordsArr.length; i++) wordsMatrix[i] = new int[wordsArr.length];
        visited = new int[wordsArr.length];
        
        for (int i = 0; i < wordsArr.length; i++) {
            for (int j = i; j < wordsArr.length; j++) {
                if (isConnectedWords(wordsArr[i], wordsArr[j]) == 1) {
                    wordsMatrix[i][j] = 1;
                    wordsMatrix[j][i] = 1;
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        int cnt = 0;
        
        int curWord = 0;
        q.offer(curWord); // begin
        visited[curWord] = 1;
        while (!q.isEmpty()) {
            curWord = q.poll();
            cnt++;
            if (cnt == 10)
                break;
            for (int i = 0; i < wordsArr.length; i++) {
                if (wordsMatrix[curWord][i] == 1 && visited[i] == 0) {
                    visited[i] = visited[curWord] + 1;
                    q.offer(i);
                }
            }
        }
        
        int answer = 0;        
        for (int i = 0; i < wordsArr.length; i++) {
            if (wordsArr[i].equals(target) == true)
                answer = visited[i] - 1;
        }
        return answer;
    }
    
    private int isConnectedWords(String w1, String w2) {
        int flag = 0;
        
        if (w1.length() != w2.length())
            return 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i))
                flag++;
            if (flag == 2)
                return 0;
        }
        return 1;
    }
}