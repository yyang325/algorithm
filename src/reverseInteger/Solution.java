package reverseInteger;

/**
 * Reverse digits of an integer.
 * @author Yang
 */

public class Solution {
    public int reverse(int x) {
        boolean isNeg = false;
        if(x < 0){
            x = 0-x;
            isNeg = true;
        }
        long res = 0;
        
        while(x > 0 && res >= 0){
            int digit = x % 10;
            res = 10 * res + digit;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        
        
        res = isNeg ? -res : res;
        return (int)res;
    }
}