class Solution {
    int answer = 0;
    int[] visited;
    public int solution(int[] info, int[][] edges) {
        visited = new int[pow(2, info.length)];
        dfs(1, info, edges, 1, 0);
        
        return answer;
    }
    
    private void dfs(int cur, int[] info, int[][] edges, int sheep, int wolf) {
        if (visited[cur] == 1 || sheep <= wolf) return ;
        visited[cur] = 1;
        if (answer < sheep)
            answer = sheep;
        
        int[] curArr = intToArr(cur, info.length);
        for (int[] e : edges) {
            if (curArr[e[0]] == 1 && curArr[e[1]] == 0) {
                curArr[e[1]] = 1;
                if (info[e[1]] == 0)
                    dfs(arrToInt(curArr, info.length), info, edges, sheep + 1, wolf);
                else
                    dfs(arrToInt(curArr, info.length), info, edges, sheep, wolf + 1);
                curArr[e[1]] = 0;
            }
            else if (curArr[e[0]] == 0 && curArr[e[1]] == 1) {
                curArr[e[0]] = 1;
                if (info[e[0]] == 0)
                    dfs(arrToInt(curArr, info.length), info, edges, sheep + 1, wolf);
                else
                    dfs(arrToInt(curArr, info.length), info, edges, sheep, wolf + 1);
                curArr[e[0]] = 0;
            }
        }
    }
    
    
    
    private int[] intToArr(int graph, int n) {
        int[] rtnArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            rtnArr[i] = graph % 2;
            graph /= 2;
        }
        return rtnArr;
    }
    
    private int arrToInt(int[] graph, int n) {
        int rtn = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            rtn *= 2;
            rtn += graph[i];
        }
        return rtn;
    }
    
    private int pow(int n, int exp) {
        int rtn = 1;
        for (int i = 1; i <= exp; i++) rtn *= n;
        
        return rtn;
    }
}