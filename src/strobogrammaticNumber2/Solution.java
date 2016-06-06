package strobogrammaticNumber2;

import java.util.*;

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        help(res, new StringBuilder(), n, n == 1);
        return res;
    }
    
    public void help(List<String> res, StringBuilder sb, int n, boolean one){
        //TODO
        if(n == 0){
            String s = sb.toString();
            if(one || s.charAt(0) != '0'){
                res.add(s);
            }
            return ;
        }
        if(n % 2 == 1){
            for(int i = 0; i < 10; i++){
                if(match(i) == i){
                    StringBuilder sbn = new StringBuilder().append(i);
                    help(res, sbn, n-1, one);
                }
            }
            return ;
        }
        
        for(int i = 0; i < 10; i++){
            if(match(i) >= 0){
                StringBuilder sbn = new StringBuilder(sb).append(i).reverse().append(match(i));
                help(res, sbn, n-2, one);
            }
        }
    }
    
    public int match(int n){
        switch(n){
            case 1: return 1;
            case 6: return 9;
            case 8: return 8;
            case 9: return 6;
            case 0: return 0;
        }
        return -1;
    }
}