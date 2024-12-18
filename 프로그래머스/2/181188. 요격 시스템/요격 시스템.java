import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int i = 0;
        while (i < targets.length) {
            answer++;
            int minLocation = targets[i][1];
            while (i < targets.length && targets[i][0] < minLocation) {   
                i++;
            }
        }
        
        return answer;
    }
}