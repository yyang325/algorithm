package sparseMatrixMultiplication;

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        
        for(int row = 0; row < A.length; row++){
            for(int k = 0; k < A[0].length; k++){
                if(A[row][k] != 0){
                    for(int col = 0; col < B[0].length; col++){
                        if(B[k][col] != 0){
                            res[row][col] += A[row][k] * B[k][col];
                        }
                    }
                }
            }
        }
        
        return res;
    }
}