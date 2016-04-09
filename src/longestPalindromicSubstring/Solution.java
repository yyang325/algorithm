package longestPalindromicSubstring;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 
 * @author Yi Yang
 */


public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return null;
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        /* one character is always palindrome */
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        
        /* more than one character */
        for(int level = 1; level < s.length(); level++){
            
            for(int i = 0; i < s.length() - level; i++){
                if(s.charAt(i) == s.charAt(i+level) && (level == 1 || dp[i+1][i+level-1])){
                    dp[i][i+level] = true;
                }else{
                    dp[i][i+level] = false;
                }
            }
        }
        
        /* find the longest substring */
        for(int level = s.length()-1; level >= 0; level--){
            for(int i = 0; i < s.length() - level; i++){
                if(dp[i][i+level]){
                    return s.substring(i, i+level+1);
                }
            }
        }
        
        return null;
    }
}