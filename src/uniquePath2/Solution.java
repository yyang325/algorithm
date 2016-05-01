package uniquePath2;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1) return 0;
        int[] arr = new int[obstacleGrid[0].length];
        for(int r = 0; r < obstacleGrid.length; r++){
            for(int c = 0; c < obstacleGrid[0].length; c++){
                if(obstacleGrid[r][c] == 1){
                    arr[c] = 0;
                }else if(r == 0){
                    arr[c] = c > 0 ? arr[c-1] : 1;
                }else if(c == 0){
                    arr[0] = arr[0];
                }else{
                    arr[c] += arr[c-1];
                }
            }
        }
        return arr[arr.length-1];
    }
}