import java.util.Arrays;

class Solution {
    public String solution(int times, int gap, int passenger, String[] timetableString) {
        int answer = 9*60;
        
        int[] timetable = Arrays.stream(timetableString).mapToInt(t -> timeToInt(t)).sorted().toArray();
        
        int busTime = 9*60;
        int line = 0;
        for (int i = 0; i < times; i++) {
            int passengerIdx = 0;
            while (line + passengerIdx < timetable.length && passengerIdx < passenger && timetable[line + passengerIdx] <= busTime)
                passengerIdx++;
            
            line += passengerIdx;
            
            if (passengerIdx == passenger && passenger > 0)
                answer = timetable[line - 1] - 1;
            else
                answer = busTime;
            busTime += gap;
        }
        
        return timeToString(answer);
    }
    
    private int timeToInt(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
    
    private String timeToString(int time) {
        String answer = "";
        
        int hour = time / 60;
        int min = time % 60;
        
        if (hour < 10)
            answer += "0";
        answer += Integer.toString(hour);
        answer += ":";
        if (min < 10)
            answer += "0";
        answer += Integer.toString(min);
    
        return answer;
    }
    
}

// 1. 버스 도착 시간 전까지 서있는 사람의 숫자를 센다.
// 2-1. 도착한 버스에 좌석이 가득찬 경우, 마지막 탑승 승객보다 1분 일찍으로 정답을 초기화.
// 2-2. 도착한 버스에 좌석이 남은 경우, 버스 탑승시간에 맞춰서 정답을 초기화.


