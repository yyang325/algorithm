package decodeWays;

public class Solution2 {
    public int numDecodings(String s) {
        if(s == null || s.length() < 1) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) > '0' && s.charAt(0) <= '9'){
            dp[1] = 1;
        }else{
            return 0;
        }
        for(int i = 1; i < s.length(); i++){
            if(check(s, i, 1)){
                dp[i+1] += dp[i];
            }
            if(check(s, i, 2)){
                dp[i+1] += dp[i-1];
            }
        }
        return dp[s.length()];
    }
    
    public boolean check(String s, int index, int digit){
        if(digit > 2 || index-digit+1 < 0) return false;
        String sub = s.substring(index-digit+1, index+1);
        for(int i = 0; i < sub.length(); i++){
            if(sub.charAt(i) < '0' || sub.charAt(i) > '9') return false;
        }
        if(digit == 2 && sub.charAt(0) == '0') return false;
        int num = Integer.parseInt(sub);
        if(num <= 0 || num > 26) return false;
        return true;
    }
}