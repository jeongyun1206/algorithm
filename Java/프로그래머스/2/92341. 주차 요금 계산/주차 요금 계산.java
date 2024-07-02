import java.util.Arrays;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        String [][] recordArr = Arrays.stream(records)
            .map(r -> r.split(" "))
            .toArray(String[][]::new);
        
        int[] times = new int[10000];
        String[] inTime = new String[10000];
        
        for (String[] record : recordArr) {
            int car = Integer.parseInt(record[1]);
            if (inTime[car] == null)
                inTime[car] = record[0];
            else {
                times[car] += timeDiff(inTime[car], record[0]);
                inTime[car] = null;
            }
        }
        
        for (int i = 0; i < 10000; i++) {
            if (inTime[i] != null)
                times[i] += timeDiff(inTime[i], "23:59");
        }
        
        return Arrays.stream(times)
            .filter(t -> t > 0)
            .map(t -> fee(fees, t))
            .toArray();
    }
    
    private int fee(int[] fees, int time) {
        int fee = fees[1];
        if (time >= fees[0]) {
            fee += ((time - fees[0]) / fees[2]) * fees[3];
            if ((time - fees[0]) % fees[2] != 0)
                fee += fees[3];
        }
        return fee;
    }
    
    private int timeDiff(String in, String out) {
        return (Integer.parseInt(out.split(":")[0]) - Integer.parseInt(in.split(":")[0])) * 60
            + (Integer.parseInt(out.split(":")[1]) - Integer.parseInt(in.split(":")[1]));
    }
}