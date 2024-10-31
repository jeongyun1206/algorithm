import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int cameraCount = 0;
        
        Arrays.sort(routes, Comparator.comparing((int[] route) -> route[1]));
        
        int routeIdx = 0;
        while (routeIdx < routes.length) {
            int cameraLocation = routes[routeIdx][1];
            cameraCount++;
            routeIdx++;
            while (routeIdx < routes.length && routes[routeIdx][0] <= cameraLocation)
                routeIdx++;
        }
        
        return cameraCount;
    }
}