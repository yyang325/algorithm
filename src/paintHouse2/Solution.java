package paintHouse2;

public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length < 1 || costs[0].length < 1) return 0;
        Integer min1 = null, min2 = null;
        for(int i = 0; i < costs.length; i++){
            //find current house min1 and min2 and their index
            int last1 = min1 == null ? 0 : min1, last2 = min2 == null ? 0 : min2;
            min1 = null; min2 = null;
            for(int j = 0; j < costs[i].length; j++){
                if(i != 0){
                	costs[i][j] += (last1 == costs[i-1][j] ? last2 : last1);
                }
                if(min1 == null || costs[i][j] <= min1){
                    min2 = min1;
                    min1 = costs[i][j];
                }else if(min2 == null || costs[i][j] <= min2){
                    min2 = costs[i][j];
                }
            }
        }
        return min1;
    }
    
    
    public static void main(String[] a){
    	int[][] costs = {{1,5,3},{2,9,4}};
    	Solution f = new Solution();
    	System.out.println(f.minCostII(costs));
    }
}