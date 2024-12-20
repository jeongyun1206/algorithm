import java.util.*;
import java.math.*;

class Solution {
    public int solution(String[] lines) {
        int[][] traffics = new int[lines.length][2];
        
        for (int i = 0; i < lines.length; i++) {
            traffics[i][1] = getEndTime(lines[i].split(" ")[1]);
            traffics[i][0] = traffics[i][1] - toMs(lines[i].split(" ")[2]) + 1;
        }
        
        int answer = 0;
        
        for (int i = 0; i < traffics.length; i++) {
            int startTime = traffics[i][1];
            int endTime = startTime + 999;
            
            int cover = 0;
            for (int j = 0; j < traffics.length; j++) {
                if (startTime <= traffics[j][0] && traffics[j][0] <= endTime)
                    cover++;
                else if (startTime <= traffics[j][1] && traffics[j][1] <= endTime)
                    cover++;
                else if (traffics[j][0] <= startTime && endTime <= traffics[j][1])
                    cover++;
            }
            if (answer < cover)
                answer = cover;
        }
        
        return answer;
    }
    
    private int getEndTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        int sec = Integer.parseInt(time.split(":")[2].substring(0, 2));
        int ms = Integer.parseInt(time.split(":")[2].substring(3, 6));
        
        return ms + sec * 1000 + min * 60 * 1000 + hour * 60 * 60 * 1000;
    }
    
    private int toMs(String sec) {
        BigDecimal ms = new BigDecimal(sec.substring(0, sec.length() - 1));
        return ms.multiply(new BigDecimal("1000")).intValue();
    }
}