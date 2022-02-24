https://nados.io/question/transpose-of-matrix-with-dimension-m-x-n




class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] arr = new int[m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[j][i] = matrix[i][j];
            }
        }
        return arr;
    }
}
