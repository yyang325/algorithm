package happyNumber;

import java.util.*;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            if(n == 1) return true;
            set.add(n);
            n = next(n);
        }
        return false;
    }
    
    public int next(int n){
        int res = 0;
        while(n > 0){
            int digit = n % 10;
            res += (digit * digit);
            n /= 10;
        }
        return res;
    }
}