class Solution {
    int answer = 0;
    public int solution(int n, int k) {
        String numString = "";
        while (n > 0) {
            numString += n % k;
            n /= k;
        }
        StringBuilder sb = new StringBuilder(numString);
        String[] numStringArr = sb.reverse().toString().split("0");
        for (String s : numStringArr) {
            if (!s.equals(""))
                answer += isPrime(Long.parseLong(s));
        }
            
        
        return answer;
    }
    
    private int isPrime(long n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return 0;
        }
        return 1;
    }
}