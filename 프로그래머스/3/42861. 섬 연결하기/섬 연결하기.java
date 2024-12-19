import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        int[] root = new int[n];
        for (int i = 0; i < root.length; i++) root[i] = i;
        
        for (int[] cost : costs) {
            if (allIslandConnected(root)) // 모든 섬이 연결됐다면
                break;
            
            int root1 = getTop(cost[0], root), root2 = getTop(cost[1], root);
            if (root1 == root2)
                continue;
            answer += cost[2];
            root[root1] = root2;
        }
        
        return answer;
    }
    
    private boolean allIslandConnected(int[] root) {
        int top = getTop(0, root);
        for (int i = 1; i < root.length; i++) {
            if (getTop(i, root) != top)
                return false;
        }
        return true;
    }
    
    private int getTop(int r, int[] root) {
        while (root[r] != r)
            r = root[r];
        return r;
    }
}