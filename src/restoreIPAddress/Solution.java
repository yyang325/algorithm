package restoreIPAddress;

import java.util.*;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        help(res, new StringBuilder(), s, 0, 0);
        return res;
    }
    
    public void help(List<String> res, StringBuilder sb, String s, int index, int count){
        if(count == 4){
            if(index == s.length()) {
                res.add(sb.toString());
            }
            return;
        }
        if(index >= s.length()) return ;
        
        for(int i = 1; i <= 3; i++){
            if(index+i > s.length()) break;
            String sub = s.substring(index, index+i);
            if(valid(sub)){
                StringBuilder sbn = new StringBuilder(sb);
                if(count != 0) sbn.append(".");
                sbn.append(sub);
                help(res, sbn, s, index+i, count+1);
            }
        }
    }
    
    public boolean valid(String s){
        int num = Integer.parseInt(s);
        if(num < 0 || num > 255) return false;
        if(!String.valueOf(num).equals(s)) return false;
        return true;
    }
}