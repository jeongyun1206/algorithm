class Solution {
    
    public int[] solution(int n, int s) {
        if (s < n) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
            
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = s/n;
        }
        for (int i = 1; i <= s%n; i++) {
            answer[n - i] = s/n + 1;
        }
        return answer;
    }
}