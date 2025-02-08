import java.util.*;
import java.util.stream.*;

class Solution {
    static final int INF = 1234567890;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> roadList = getRoadList(n, roads);
        
        int[] dist = new int[n + 1];
        for (int i = 0; i < dist.length; i++) dist[i] = INF;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[destination] = 0;
        pq.add(new Node(destination, dist[destination]));
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            
            for (int next : roadList.get(curNode.id)) {
                if (curNode.dist + 1 < dist[next]) {
                    dist[next] = curNode.dist + 1;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = (dist[sources[i]] == INF) ? -1 : dist[sources[i]];
        }
        return answer;
    }
    
    private List<List<Integer>> getRoadList(int n, int[][] roads) {
        List<List<Integer>> roadList = new ArrayList<>();
        for (int i = 0; i <= n; i++) roadList.add(new ArrayList<>());
        
        for (int[] road : roads) {
            roadList.get(road[0]).add(road[1]);
            roadList.get(road[1]).add(road[0]);
        }
        
        // for (int i = 0; i <= n; i++) {
        //     System.out.print("form " + i + " : ");
        //     for (int to : roadList.get(i))
        //         System.out.print(to + " ");
        //     System.out.println("");
        // }        
        return roadList;
    }
}

class Node implements Comparable<Node> {
    public int id;
    public int dist;

    public Node(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.dist, other.dist);
    }
}

/*
1. 각 지역에는 고유 아이디가 존재.
2. 각 지역간 길을 통과하는데 걸리는 시간은 1.
3. 최단시간 내에 도착지로 이동.
4. 도착지로 이동이 불가능한 경우도 존재.
5. 
*/