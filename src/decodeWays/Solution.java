package decodeWays;

public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() < 1 || s.charAt(0) == '0') return 0;
        if(s.length() == 1 && s.charAt(0) >= '1' && s.charAt(0) <= '9') return 1;
        int n1 = 1, n2 = 1;
        for(int i = 0; i < s.length(); i++){
            if(i == 0){
                if(check(s.substring(0,1))){
                    n2 = 1;
                }else{
                    return 0;
                }
            }else{
                int count = 0;
                if(check(s.substring(i,i+1))){
                    count += n2;
                }
                
                if(check(s.substring(i-1, i+1))){
                    count += n1;
                }
                if(count == 0) return 0;
                n1 = n2;
                n2 = count;
            }
        }
        return n2;
    }
    
    public boolean check(String s){
        if(s.length() == 1){
            return s.charAt(0) >= '1' && s.charAt(0) <= '9';
        }else if(s.length() == 2){
            int temp = Integer.parseInt(s);
            return temp >= 10 && temp <= 26;
        }
        return false;
    }
}