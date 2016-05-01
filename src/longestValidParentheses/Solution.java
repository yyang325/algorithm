package longestValidParentheses;
wrong answer
public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 1) return 0;
        int left = 0;
        int max = 0, count = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
                left++;
            }else{
                if(left > 0){
                    count++;
                    left--;
                    if(left == 0){
                    	max = Math.max(max, count);
                    }
                }else{
                    max = Math.max(max, count);
                    left = 0;
                    count = 0;
                }
            }
        }
        return max;
    }
    
    
    public static void main(String[] a){
    	Solution f = new Solution();
    	System.out.println(f.longestValidParentheses("()"));
    }
}