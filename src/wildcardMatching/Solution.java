package wildcardMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            dp[i][0] = false;
        }
        
        for(int i = 1; i <= p.length(); i++){
            dp[0][i] = p.charAt(i-1) == '*' && dp[0][i-1];
        }
        
        for(int row = 1; row < dp.length; row++){
            for(int col = 1; col < dp[0].length; col++){
                if(p.charAt(col-1) == '*'){
                    dp[row][col] = dp[row-1][col] || dp[row][col-1];
                }else if(s.charAt(row-1) == p.charAt(col-1) || p.charAt(col-1) == '?'){
                    dp[row][col] = dp[row-1][col-1];
                }else{
                    dp[row][col] = false;
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
    
    public static void main(String[] args){
    	Solution f = new Solution();
    	String s = "aa", p = "a*";
    	System.out.println(f.isMatch(s, p));
    }
}