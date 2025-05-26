class Solution {
    int answer = 0;
    public int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            dfs(s, i, i);
            if (i + 1 < s.length())
                dfs(s, i, i + 1);
        }
            
        
        return answer;
    }
    
    private void dfs(String s, int l, int r) {
        if (l < 0 || r > s.length() - 1 || !isPalindrome(s, l, r))
            return;
        answer = Math.max(r - l + 1, answer);
        dfs(s, l - 1, r + 1);
        // dfs(s, l, r + 1);
        // dfs(s, l - 1, r);
    }
    
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}