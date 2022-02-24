https://leetcode.com/problems/rotate-image/


1st step transpose matrix
2nd swap ele in row i.e ((0,0) <-> (0,n-1))

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int i = 0;
        int j = n - 1;
        for(int idx = 0; idx < n; idx++){
            while(i <= j){
                int temp = matrix[idx][i];
                matrix[idx][i] = matrix[idx][j];
                matrix[idx][j] = temp;
                i++;
                j--;
            }
            i = 0;
            j = n - 1;
        }
    }
}
