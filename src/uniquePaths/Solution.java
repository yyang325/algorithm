package uniquePaths;

public class Solution {
    public int uniquePaths(int m, int n) {
        if(m < 1 || n < 1) return 0;
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) arr[i] =1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                arr[j] = arr[j] + arr[j-1];
            }
        }
        return arr[arr.length-1];
    }
}