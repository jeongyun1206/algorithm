class Solution {
    int[] visited = new int[1000000];
    int answer = 1234567890;
    public int solution(int[][] info, int n, int m) {
        backtracking(info, n, m, 0, 0, 0);
        if (answer == 1234567890)
            return -1;
        return answer;
    }
    
    private void backtracking(int[][] info, int n, int m, int a, int b, int level) {
        int bitmap = (level << 14) + (a << 7) + b;
        if (visited[bitmap] == 1)
            return;
        visited[bitmap] = 1;
        if (a >= n || b >= m || a > answer)
            return;
        
        if (level == info.length) {
            answer = Math.min(answer, a);
            return;
        }
        
        backtracking(info, n, m, a + info[level][0], b, level + 1);
        backtracking(info, n, m, a, b + info[level][1], level + 1);
    }
}