import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        // 노드 수 계산
        int nodeCnt = 0;
        for (int[] edge : edges) {
            nodeCnt = Math.max(nodeCnt, edge[0]);
            nodeCnt = Math.max(nodeCnt, edge[1]);
        }
        // 리스트 간선 목록으로 변경
        // 노드별 들어오는 간선 수와 나가는 간선 수 계산
        int[] inCommingEdge = new int[nodeCnt + 1];
        int[] outGoingEdge = new int[nodeCnt + 1];
        
        List<List<Integer>> edgeList = new ArrayList<>();
        for (int i = 0; i <= nodeCnt; i++) {
            edgeList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            outGoingEdge[edge[0]]++;
            inCommingEdge[edge[1]]++;
            edgeList.get(edge[0]).add(edge[1]);
        }
        
        // 시작 노드 결정
        int startNode = 0;
        for (int i = 1; i < nodeCnt + 1; i++) {
            if (outGoingEdge[i] >= 2 && inCommingEdge[i] == 0) {
                startNode = i;
                break;
            }
        }
        answer[0] = startNode;
        // 시작 노드로 그래프 시작점 결정
        
        List<Integer> graphStartNodeList = edgeList.get(startNode);
        // 그래프 시작점 순회하면서 모양 결정
        int[] visited = new int[nodeCnt + 1];
        for (int graphStartNode : graphStartNodeList) {
            int type = determinGraphType(graphStartNode, edgeList, outGoingEdge, inCommingEdge, visited);
            answer[type]++;
        }
        // 도넛 모양은 시작점으로 되돌아온다.
        // 막대 모양은 나가는 간선이 없는 노드가 존재한다.
        // 8자 모양은 나가는 간선이 2개인 노드가 존재한다.
        return answer;
    }
    
    private int determinGraphType(int graphStartNode, List<List<Integer>> edgeList, 
                                  int[] outGoingEdge, int[] inCommingEdge, int[] visited) {
        
        int node = graphStartNode;
        if (outGoingEdge[node] == 2)
            return 3;
        else if (outGoingEdge[node] == 0)
            return 2;
        while (true) {
            for (int i : edgeList.get(node)) {
                if (visited[i] == 0) {
                    node = i;
                    break;
                }
            }
            
            if (outGoingEdge[node] == 2)
                return 3;
            else if (node == graphStartNode)
                return 1;
            else if (outGoingEdge[node] == 0)
                return 2;
            visited[node] = 1;
        }
    }
}