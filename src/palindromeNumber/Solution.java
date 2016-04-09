package palindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int bits = (int) (Math.log(x) / Math.log(10)) + 1;
        while(bits > 1){
            int digit = x % 10;
            int maxBit = (int) (x / Math.pow(10, bits-1));
            if(digit != maxBit) return false;
            x %= Math.pow(10, bits-1);
            x /= 10;
            bits -= 2;
        }
        return true;
    }
}