import java.util.*;

class Solution {
    public int solution(int[] teamA, int[] teamB) {
        int answer = 0;
        
        Arrays.sort(teamA);
        Arrays.sort(teamB);
        
        int teamAIdx = 0, teamBIdx = 0;
        while (teamAIdx < teamA.length && teamBIdx < teamB.length) {
            while (teamBIdx < teamB.length && teamA[teamAIdx] >= teamB[teamBIdx])
                teamBIdx++;
            if (teamBIdx == teamB.length)
                break;
            answer++;
            teamAIdx++;
            teamBIdx++;
        }
        
        return answer;
    }
}