package coinChange;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length < 1 || amount < 1) return 0;
        
        int[] dp = new int[amount+1];
        dp[0] = 0; // todo
        for(int i = 1; i < dp.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && dp[i-coins[j]] >= 0){
                    min = Math.min(min, dp[i-coins[j]]);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
            
        }
        
        return dp[amount];
    }
}