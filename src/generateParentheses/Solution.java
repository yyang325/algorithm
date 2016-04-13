package generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        int left = n, right = n;
        List<String> res = new ArrayList<String>();
        help(res, new StringBuilder(), left, right);
        return res;
    }
    
    public void help(List<String> res, StringBuilder sb, int left, int right){
        if(left > right || left < 0 || right < 0) return;
        if(left == 0 && right == 0){
            res.add(sb.toString());
            return ;
        }
        
        StringBuilder sb1 = new StringBuilder(sb);
        sb1.append('(');
        help(res, sb1, left-1, right);
        
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(')');
        help(res, sb2, left, right-1);
    }
}