package uniquePaths2;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1) return 0;
        int[] count = new int[obstacleGrid[0].length];
        for(int i = 0; i < count.length; i++){
            if(obstacleGrid[0][i] == 1) count[i] = 0;
            else if(i == 0) count[0] = 1;
            else {
                count[i] = count[i-1];
            }
        }
        for(int i = 1; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j++){
                if(j != 0)
                    count[j] = obstacleGrid[i][j] == 1 ? 0 : count[j] + count[j-1];
                else
                    count[j] = (obstacleGrid[i][j] == 1 || count[j] == 0) ? 0 : 1;
            }
        }
        return count[count.length-1];
    }
}