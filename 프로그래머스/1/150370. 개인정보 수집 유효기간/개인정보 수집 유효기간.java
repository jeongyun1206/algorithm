import java.util.*;
import java.util.stream.*;
import java.time.*;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 약관별 유효기간 추출
        Map<String, Integer> policies = Arrays.stream(terms)
            .collect(Collectors.toMap(t -> t.split(" ")[0], t -> Integer.parseInt(t.split(" ")[1])));
        
        // privacies의 순서대로 만료 날짜 계산
        List<LocalDate> expireTime = Arrays.stream(privacies)
            .map(p -> caculateExpireDate(p, policies.get(p.split(" ")[1])))
            .collect(Collectors.toList());
        
        LocalDate todayDate = caculateExpireDate(today, 0);
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < expireTime.size(); i++) {
            if (!todayDate.isBefore(expireTime.get(i)))
                answer.add(i + 1);
        }
        
        // today기준으로 순회하면서 만료된 수 계산.
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private LocalDate caculateExpireDate(String privacy, int plusMonth) {
        int year = Integer.parseInt(privacy.substring(0, 4));
        int month = Integer.parseInt(privacy.substring(5, 7));
        int day = Integer.parseInt(privacy.substring(8, 10));
        
        LocalDate date = LocalDate.of(year, month, day);
        return date.plusMonths(plusMonth);
    }
}