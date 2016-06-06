package strobogrammaticNumber;

public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() < 1) return false;
        if(num.length() == 1) return match(num.charAt(0)-'0', num.charAt(0)-'0');
        int left = 0, right = num.length()-1;
        while(left <= right){
            if(!match(num.charAt(left++)-'0', num.charAt(right--)-'0')) return false;
        }
        return true;
    }
    
    public boolean match(int i, int j){
        switch(i){
            case 1: return j == 1;
            //case 2: return j == 5;
            //case 5: return j == 2;
            case 6: return j == 9;
            case 8: return j == 8;
            case 9: return j == 6;
            case 0: return j == 0;
        }
        return false;
    }
}