class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[200];
        
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                answer++;
                dfs(i, n, visited, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int cur, int n, int[] visited, int[][] computers) {
        if (visited[cur] == 1)
            return ;
        visited[cur] = 1;
        
        for (int i = 0; i < n; i++) {
            if (computers[cur][i] == 1) { // cur와 i가 연결
                dfs(i, n, visited, computers);
            }
        }
    }
}